package com.accesadades.botiga.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.accesadades.botiga.Model.Category;
import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Model.Subcategory;
import com.accesadades.botiga.Service.CategoryService;
import com.accesadades.botiga.Service.ProductService;
import com.accesadades.botiga.Service.SubcategoryService;

import java.util.Set;

@Controller
public class WebController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoriaService;

    @Autowired
    private SubcategoryService subcategoriaService;

    @RequestMapping(value = "/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/catalog")
    public String catalog(Model model) {
        Set<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "catalog";
    }

    @RequestMapping(value = { "/search", "/prodname" }, method = { RequestMethod.GET, RequestMethod.POST })
    public String searchProductByName(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null) {
            Product product = productService.findProductsByName(name);
            model.addAttribute("product", product);
        }
        return "search"; // Referencia a search.html en el directorio templates
    }

    @GetMapping("/productes/desar") // Gestiona peticions GET a la ruta "/productes/desar"
    public String showCreateProductForm(Model model) {
        model.addAttribute("product", new Product()); // Afegeix un nou objecte Product al model
        return "product"; // Retorna la vista "product.html"
    }

    @PostMapping("/productes/desar") // Gestiona peticions POST a la ruta "/productes/desar"
    public String saveProduct(@RequestParam String nom,
                              @RequestParam String descripcio,
                              @RequestParam long unitats,
                              @RequestParam float preu,
                              @RequestParam String fabricant,
                              @RequestParam String subcategoria,
                              @RequestParam String categoria,
                              Model model) {

        // Verifica si la categoria existeix
        Category existingCategory = categoriaService.findByName(categoria);
        if (existingCategory == null) {
            // Crea una nova categoria si no existeix
            existingCategory = new Category();
            existingCategory.setName(categoria);
            categoriaService.saveCategory(existingCategory);
        }

        // Verifica si la subcategoria existeix i pertany a la categoria donada
        Subcategory existingSubcategory = subcategoriaService.findByName(subcategoria);
        if (existingSubcategory == null) {
            // Crea una nova subcategoria si no existeix
            existingSubcategory = new Subcategory();
            existingSubcategory.setName(subcategoria);
            existingSubcategory.setCategory(existingCategory);(existingCategory);
            subcategoriaService.saveSubcategory(existingSubcategory);
        } else if (!existingSubcategory.getCategory().getName().equals(categoria)) {
            // Si la subcategoria no correspon a la categoria dona error
            model.addAttribute("error", "La subcategoria no correspon a la categoria donada.");
            return "product";
        }

        // Crea i guarda el nou producte
        Product product = new Product();
        product.setName(nom);
        product.setDescription(descripcio);
        product.setUnits(unitats);
        product.setPrice(preu);
        product.setCompany(fabricant);
        productService.saveProduct(product);

        return "redirect:/catalog"; // Redirigeix a la pàgina del catàleg
    }
}
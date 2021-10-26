package lk.abc.spring.controller;

import lk.abc.spring.dto.AdminDTO;
import lk.abc.spring.dto.ProductDTO;
import lk.abc.spring.exception.NotFoundException;
import lk.abc.spring.service.AdminService;
import lk.abc.spring.service.ProductService;
import lk.abc.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 10/21/21
 */
@RestController
@RequestMapping("api/v1/product")
@CrossOrigin
public class ProductManageFormController {

    @Autowired
    private ProductService productService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE,
            path ="/crud/add" )
    public ResponseEntity<StandardResponse> saveProduct(@RequestBody ProductDTO dto ){
        productService.addProduct(dto);
        return new ResponseEntity<>(new StandardResponse("201","Product Added",dto), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE,
            path ="/crud/update" )
    public ResponseEntity<StandardResponse> updateProduct(@RequestBody ProductDTO dto ){
        if (dto.getId().trim().length() <= 0) {
            throw new NotFoundException("No ID Provided!!");
        }
        productService.updateProduct(dto);
        return new ResponseEntity<>(new StandardResponse("200","Product Updated",dto),HttpStatus.ACCEPTED);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            params ={"id"} )
    public ResponseEntity<StandardResponse> deleteAdmin(@RequestParam String id ){
        productService.deleteProduct(id);
        return new ResponseEntity<>(new StandardResponse("200","Product Deleted!!",null),HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StandardResponse> getAllProducts(){
        ArrayList<ProductDTO> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(new StandardResponse("200","Done",allProducts),HttpStatus.OK);
    }
}

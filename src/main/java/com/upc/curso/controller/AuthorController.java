package com.upc.curso.controller;

import com.upc.curso.entidades.Author;
import com.upc.curso.negocio.AuthorNegocio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class AuthorController {
   @Autowired
   public AuthorNegocio negocio;
   Logger logger = LoggerFactory.getLogger(AuthorController.class);

   @GetMapping("/authors")
   public ResponseEntity<List<Author>>  obtenerAutores(){
	   return new ResponseEntity<List<Author>>(negocio.listado(),HttpStatus.OK);
   }

    @GetMapping("/authors/{nombre}")
    public ResponseEntity<List<Author>>  obtenerNombreAutores(@PathVariable(value = "nombre") String nombre){
        return new ResponseEntity<List<Author>>(negocio.obtenerReportePorDescripcion(nombre),HttpStatus.OK);
    }

   @PostMapping("/author")
   public ResponseEntity<Author> crearAutor(@RequestBody Author author) {
       Author p;
       try {
           logger.debug("Creando objeto");
           p = negocio.registrar(author);
       }catch(Exception e){
           logger.error("Error de creación",e);
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo crear, sorry", e);
       }
	   return new ResponseEntity<Author>(p, HttpStatus.OK);
   }

   @PutMapping("/author")
   public ResponseEntity<Author> actualizarAutor(@RequestBody Author authorDetalle) {
       Author author;
       try {
           logger.debug("Actualizando producto");
           author = negocio.actualizarProducto(authorDetalle);
           logger.debug("Producto Actualizado");
           return new ResponseEntity<Author>(author, HttpStatus.OK);
       } catch (Exception e) {
           logger.error("Error de Actualización ", e);
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo actualizar, sorry");
       }
   }
   
   @DeleteMapping("/author/{codigo}")
   public ResponseEntity<Author> borrarAutor(@PathVariable(value = "codigo") Long codigo){
       try {
           logger.debug("Eliminando objeto");
           return new ResponseEntity<Author>(negocio.borrarProducto(codigo), HttpStatus.OK);
       } catch (Exception e) {
           logger.error("Error de Eliminación ", e);
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo eliminar, sorry");
       }
   }


    @GetMapping("/entidad/{codigo}")
    public ResponseEntity<Author> obtenerEntidad(@PathVariable(value = "codigo") Long codigo){
        Author p;
        try {
            logger.debug("Buscando entidad");
            p = negocio.buscar(codigo);
        }catch(Exception e){
            logger.error("Error de Obtener Entidad");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mi mensaje");
        }
        return new ResponseEntity<Author>(p, HttpStatus.OK);
    }
   
}

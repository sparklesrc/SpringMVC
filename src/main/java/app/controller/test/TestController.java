/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Administrador
 */
//Toda clase q sea controller debe tener su anotacion
//El RequestMapping sobre la clase dice q este controller va mapear este URL
@Controller
@RequestMapping("/")
public class TestController {

    //Aca va el CRUD
    /*
     
     /Test  ->  Listar
     /Test/nuevo    -> Nuevo(FORM)
     /Test/update/id    ->  Editar (FORM)
     /Test/delete/id 
     /test/save
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        //Este metodo va responder al GET de la ruta mencionada arriba "/"
        //ESTE GET es de GetRequest... solo se puede hacer esto 1 vez
        model.addAttribute("mensaje", "METODO INDEX");//declaro un model y 
        //al model le agrego atributos... le agrego objetos lo q sea y en la vista lo puedo leer

        //Este model es una especie de contenedor q sirve para enviar al objeto al cliente
        //Solo servira una vez... solo se mostrara una vez no en otros lados

        return "test";
        //En todo metodo de Spring
        //cuando se retorna un String... va buscar una vista con ese nombre...
        //Ver app.xml   <<<< ViewResolver
    }

    @RequestMapping("ejemplo")
    public String ejemplo(Model model) {
        model.addAttribute("mensaje", "METODO EJEMPLO");

        return "test";
    }

    //Esto limita solo a q el metodo se ejecute con POST
    //si lo colocamos de frente en el URL no se podra ya q seria un GET
    @RequestMapping(value = "ejemploPost", method = RequestMethod.POST)
    public String ejemploPost(Model model) {
        model.addAttribute("mensaje", "METODO POST");

        return "test";
    }

    //Recibir un Parametro en la URL
    /*
     
     ?id=10&codigo=20
     
     Pero ahora sera        test/actualizar/10  <<10 sera el parametro
     */
    @RequestMapping("actualizar/{id}")
    public String parametroUrl(Model model, @PathVariable("id") String id) {
        //Para coger el {id}
        //hacemos
        //@PathVariable("id")String id

        model.addAttribute("mensaje", "PARAMETRO en URL " + id);

        return "test";
    }

    @RequestMapping("guardar")
    public String guardarParamether(Model model,
            @RequestParam String nombres, @RequestParam String apellidos) {
            //RequestParam es parametro a parametro... pueden ser n

        model.addAttribute("mensaje", "USUARIO " + nombres + " " + apellidos);

        return "test";
    }

    @RequestMapping("guardarDos")
    public String guardarAttribute(@ModelAttribute PersonaTest persona
            ,Model model) {
            //Con el ModelAttribute... especifico un tipo de Modelo

        model.addAttribute("mensaje", "USUARIO " + persona.getNombres() +" "+
                persona.getApellidos());

        return "test";
    }
}

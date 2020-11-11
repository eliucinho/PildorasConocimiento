package hn.gob.sar.desa.pildora.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hn.gob.sar.desa.pildora.app.modelos.Contribuyente;
import hn.gob.sar.desa.pildora.app.servicios.ContribuyenteServicio;

@Controller
public class ContribuyenteUIControlador {	
	@Autowired
	private ContribuyenteServicio servicio;
	
	@RequestMapping("/")
	public String index(Model model) {
		setParametro(model,"lista", servicio.getTodos());
		return "index";
	}
		
	@GetMapping("/crear")
	public String irCrear( Model model) {
		setParametro(model,"contribuyente", new Contribuyente());
		return "contribuyente";
	}
        
        @GetMapping("/actualizar/{id}")
	public String irActualizar(@PathVariable("id") Long id , Model model) {
		setParametro(model,"contribuyente", servicio.getValor(id));
		return "contribuyente";
	}
	
	@PostMapping("/guardar")
	public String guardar(Contribuyente contribuyente, Model model) {
		servicio.guardar(contribuyente);
		return "redirect:/";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		servicio.eliminar(id);		
		return "redirect:/";
	}
	
	public void setParametro(Model model, String atributo, Object valor){
            model.addAttribute(atributo, valor);
        }

}

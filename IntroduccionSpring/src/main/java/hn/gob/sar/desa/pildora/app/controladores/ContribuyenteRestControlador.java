package hn.gob.sar.desa.pildora.app.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.gob.sar.desa.pildora.app.modelos.Contribuyente;
import hn.gob.sar.desa.pildora.app.servicios.ContribuyenteServicio;
import java.util.Optional;

@RestController
@RequestMapping(value = "/ws/contribuyente/")
@CrossOrigin("*")
public class ContribuyenteRestControlador {

	@Autowired
	private ContribuyenteServicio servicio;

	@GetMapping(value = "/")
	public List<Contribuyente> getTodos() {
		return servicio.getTodos();
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Contribuyente> getById(@PathVariable Long id) {
		return servicio.getValor(id);
	}

	@PostMapping(value = "/guardar")
	public Contribuyente guardar(@RequestBody Contribuyente contribuyente) {
		return servicio.guardar(contribuyente);
	}

	@GetMapping(value = "/eliminar/{id}")
	public Optional<Contribuyente> eliminar(@PathVariable Long id) {
		Optional<Contribuyente> contribuyente = servicio.getValor(id);
		servicio.eliminar(id);		
		return contribuyente;
	}

}



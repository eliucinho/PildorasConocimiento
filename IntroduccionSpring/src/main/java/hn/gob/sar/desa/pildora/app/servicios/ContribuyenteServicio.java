/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.gob.sar.desa.pildora.app.servicios;

import hn.gob.sar.desa.pildora.app.repositorios.ContribuyenteRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.gob.sar.desa.pildora.app.modelos.Contribuyente;
import java.util.Optional;

@Service
public class ContribuyenteServicio {
        @Autowired
	private ContribuyenteRepositorio repositorio;
        
	public Contribuyente guardar(Contribuyente entity) {
		return repositorio.save(entity);
	}

	public void eliminar(Long id) {
		repositorio.deleteById(id);
	}

	public Optional<Contribuyente> getValor(Long id) {
		return repositorio.findById(id);
	}

	public List<Contribuyente> getTodos() {
		return (List<Contribuyente>) repositorio.findAll();
	}
}



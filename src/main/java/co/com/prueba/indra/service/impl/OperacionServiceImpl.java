/**
 * 
 */
package co.com.prueba.indra.service.impl;


import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.com.prueba.indra.model.Operacion;
import co.com.prueba.indra.repository.OperacionRepository;
import co.com.prueba.indra.service.OperacionService;

/**
 * @author Jonathan Arroyo Reina
 *
 */
@Service
public class OperacionServiceImpl implements OperacionService {

	@Autowired
	private OperacionRepository operacionRepository;
	
	
	@Override
	public Operacion save(Operacion entity) throws Exception {
		
		switch (entity.getTipoOperacion().getSimbolo()) {
		case "x":
			entity.multiplicacion();
			break;

		default:
			throw new Exception("La operación no existe en el sistema");

		}
		
		entity.setFechaCreacion(new Timestamp(new Date().getTime()));
		return operacionRepository.save(entity);
	}


	@Override
	public Page<Operacion> list(Pageable pageable) throws Exception {
		return operacionRepository.findAll(pageable);
	}


	@Override
	public Boolean clearAll() throws Exception {
		operacionRepository.deleteAll();
		return Boolean.TRUE;
	}

}

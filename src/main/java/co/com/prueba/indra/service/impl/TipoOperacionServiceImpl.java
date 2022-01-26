/**
 * 
 */
package co.com.prueba.indra.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.prueba.indra.model.TipoOperacion;
import co.com.prueba.indra.repository.TipoOperacionRepository;
import co.com.prueba.indra.service.TipoOperacionService;

/**
 * @author Jonathan Arroyo Reina
 *
 */
@Service
public class TipoOperacionServiceImpl implements TipoOperacionService {

	@Autowired
	private TipoOperacionRepository tipoOperacionRepository;
	

	@Override
	public List<TipoOperacion> list() throws Exception {
		return tipoOperacionRepository.findAll();
	}



}

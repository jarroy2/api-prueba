/**
 * 
 */
package co.com.prueba.indra.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.com.prueba.indra.model.Operacion;

/**
 * @author Jonathan Arroyo Reina
 *
 */
public interface OperacionService {

	Operacion save(Operacion entity) throws Exception;

	Page<Operacion> list(Pageable pageable) throws Exception;
	
	Boolean clearAll() throws Exception;
}

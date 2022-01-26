/**
 * 
 */
package co.com.prueba.indra.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import co.com.prueba.indra.model.Operacion;

/**
 * @author Jonathan Arroyo Reina
 *
 */
public interface OperacionRepository extends JpaRepository<Operacion, Long> {

	Page<Operacion> findAll(Pageable pageable);

}

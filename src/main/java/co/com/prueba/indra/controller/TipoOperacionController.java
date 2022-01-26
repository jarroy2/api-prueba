/**
 * 
 */
package co.com.prueba.indra.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.prueba.indra.model.TipoOperacion;
import co.com.prueba.indra.response.GeneralResponse;
import co.com.prueba.indra.service.TipoOperacionService;

/**
 * @author Jonathan Arroyo Reina
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tipo-operacion")
public class TipoOperacionController {

	@Autowired
	private TipoOperacionService tipoOperacionService;
	
	/**
	 * Log function
	 */
	private static final Logger LOG = LoggerFactory.getLogger(TipoOperacionController.class);
	
	@GetMapping("")
	public ResponseEntity<GeneralResponse<List<TipoOperacion>>> findAllTipo() {
		GeneralResponse<List<TipoOperacion>> response = new GeneralResponse<>();
		HttpStatus status = null;
		List<TipoOperacion> data = null;
		try {
			
			
			data = tipoOperacionService.list();
			response.setSuccess(true);
			response.setData(data);
			status = HttpStatus.OK;
			LOG.info("findAll ejecutado");


		} catch (Exception ex) {
			response.setMessage(ex.getMessage());
			response.setSuccess(false);
			status = HttpStatus.INTERNAL_SERVER_ERROR;

		}

		return new ResponseEntity<>(response, status);
	}
	
	
}

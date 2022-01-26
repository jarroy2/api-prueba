/**
 * 
 */
package co.com.prueba.indra.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.prueba.indra.model.Operacion;
import co.com.prueba.indra.response.GeneralResponse;
import co.com.prueba.indra.service.OperacionService;

/**
 * @author Jonathan Arroyo Reina
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/operacion")
public class OperacionController {

	@Autowired
	private OperacionService operacionService;
	
	/**
	 * Log function
	 */
	private static final Logger LOG = LoggerFactory.getLogger(OperacionController.class);
	
	@GetMapping("")
	public ResponseEntity<GeneralResponse<Page<Operacion>>> findAll(
			@RequestParam(defaultValue = "0", name = "page") int pageIndex,
			@RequestParam(defaultValue = "10", name = "size") int pageSize,
			@RequestParam(defaultValue = "id", name = "sortField") String sortBy,
			@RequestParam(defaultValue = "descend", name = "sortOrder") String sortOrder) {
		GeneralResponse<Page<Operacion>> response = new GeneralResponse<>();
		HttpStatus status = null;
		Page<Operacion> data = null;
		try {
			
			Sort sort = Sort.unsorted();
			if (sortBy != null) {
				if (sortOrder.equalsIgnoreCase("ascend")) {
					sort = Sort.by(Direction.ASC, sortBy);
				} else {
					sort = Sort.by(Direction.DESC, sortBy);
				}
			}

			data = operacionService.list(PageRequest.of(pageIndex, pageSize, sort));
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
	
	@PostMapping("")
	public ResponseEntity<GeneralResponse<Operacion>> save(@RequestBody Operacion entity) {

		GeneralResponse<Operacion> response = new GeneralResponse<>();
		HttpStatus status = null;

		try {

			entity = operacionService.save(entity);
			response.setMessage("Operacion almacenada correctamente");
			response.setSuccess(true);
			response.setData(entity);
			status = HttpStatus.OK;
			LOG.info("save ejecutado");

		} catch (Exception ex) {
			LOG.error("error generado "+ ex.getMessage());
			response.setMessage(ex.getMessage());
			response.setSuccess(false);
			status = HttpStatus.INTERNAL_SERVER_ERROR;

		}

		return new ResponseEntity<>(response, status);

	}
	
	
	@DeleteMapping("")
	public ResponseEntity<GeneralResponse<Boolean>> deleteAll() {

		GeneralResponse<Boolean> response = new GeneralResponse<>();
		HttpStatus status = null;

		try {

			Boolean data = operacionService.clearAll();
			response.setMessage("Se han limpiado todos los registros");
			response.setSuccess(true);
			response.setData(data);
			status = HttpStatus.OK;
			LOG.info("deleteAll ejecutado");

		} catch (Exception ex) {
			LOG.error("error generado "+ ex.getMessage());
			response.setMessage(ex.getMessage());
			response.setSuccess(false);
			status = HttpStatus.INTERNAL_SERVER_ERROR;

		}

		return new ResponseEntity<>(response, status);

	}
}

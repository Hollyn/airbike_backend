package com.airbike.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.airbike.message.request.VehiculeForm;
import com.airbike.model.User;
import com.airbike.model.Vehicule;
import com.airbike.repository.UserRepository;
import com.airbike.repository.VehiculeRepository;
import com.airbike.utils.ErrorException;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api")
public class VehiculeController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VehiculeRepository vehiculeRepository;

	@GetMapping("/vehicules")
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Vehicule> getAllVehicule() {
		return vehiculeRepository.findAll();
	}

	@GetMapping("/user/{userId}/vehicules")
	public List<Vehicule> getAllCommentsByPostId(@PathVariable(value = "userId") Long userId) {
		return vehiculeRepository.findByUserId(userId);
	}

	@PostMapping("/vehicule")
	public Vehicule registerVehiculel(@RequestBody VehiculeForm vehiculeRequest) {

		User user = userRepository.findUserById(vehiculeRequest.getUserId());
		String imgName = new Date().getTime() + ".png";

		saveImage(imgName, vehiculeRequest.getPicture());

		// create vehicule
		Vehicule vehicule = new Vehicule(vehiculeRequest.getColor(), vehiculeRequest.getMark(),
				vehiculeRequest.getModel(), vehiculeRequest.getYear(), vehiculeRequest.getPower(),
				vehiculeRequest.getNumberplate(), imgName, vehiculeRequest.getDaily_price(),
				vehiculeRequest.getDescription(), user);

		return vehiculeRepository.save(vehicule);
	}

	@PostMapping("/vehicule/{id}")
	public ResponseEntity<?> editVehicule(@PathVariable long id, @Valid @RequestBody VehiculeForm vehiculeRequest) {

		if (!vehiculeRepository.existsById(id)) {
			return ResponseEntity.ok(new Gson().toJson(new ErrorException(409, "This vehicule does not exist.")));
		}

		if (!vehiculeRepository.existsById(id)) {
			return ResponseEntity.ok(new Gson().toJson(new ErrorException(409, "This vehicule does not exist.")));
		}

		// get the vehicule
		Vehicule vehicule = vehiculeRepository.findById(id);
		String imgName = new Date().getTime() + ".png";

		saveImage(imgName, vehiculeRequest.getPicture());

		// edit vehicule
		vehicule.setColor(vehiculeRequest.getColor());
		vehicule.setMark(vehiculeRequest.getMark());
		vehicule.setModel(vehiculeRequest.getModel());
		vehicule.setYear(vehiculeRequest.getYear());
		vehicule.setPower(vehiculeRequest.getPower());
		vehicule.setPhoto(imgName);
		vehicule.setNumberPlate(vehiculeRequest.getNumberplate());
		vehicule.setDaily_price(vehiculeRequest.getDaily_price());
		vehicule.setDescription(vehiculeRequest.getDescription());

		// save vehicule
		return ResponseEntity.ok(vehiculeRepository.save(vehicule));

	}
	

	public void saveImage(String name, String base64) {
		try {
			byte[] scanBytes = Base64.decodeBase64(base64);

			///////////////////////////////////////////////////////////////
			// Creating the directory to store file/data/image ////////////

			// String rootPath = System.getProperty("catalina.home");
			String rootPath = new File(".").getCanonicalPath();

			File fileSaveDir = new File(rootPath + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "image");

			// Creates the save directory if it does not exists
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdirs();
			}

			File scanFile = new File(fileSaveDir.getAbsolutePath() + File.separator + name);
			BufferedOutputStream scanStream = new BufferedOutputStream(new FileOutputStream(scanFile));
			scanStream.write(scanBytes);
			scanStream.close();

		} catch (Exception e) {
		}
	}

	@GetMapping("/vehicule/{id}")
	public ResponseEntity<?> deleteVehicule(@PathVariable("id") long id) {
		if (!vehiculeRepository.existsById(id)) {
			return ResponseEntity.ok(new Gson().toJson(new ErrorException(400, "This vehicule doesn't exist.")));
		}

		Vehicule vehicule = vehiculeRepository.findById(id);
		vehicule.setDeleted(true);

		vehiculeRepository.save(vehicule);

		return ResponseEntity.ok(new Gson().toJson(new ErrorException(200, "Deleted successfully!")));
	}

//	@PostMapping("/vehicule")
//	public ResponseEntity<?> registerVehicule(@Valid @RequestBody VehiculeForm vehiculeRequest) {
//
//		if (vehiculeRepository.existsByNumberPlate(vehiculeRequest.getNumberplate())) {
//			return ResponseEntity
//					.ok(new Gson().toJson(new ErrorException(409, "This numberplate is already registered")));	
//		}
//
//		// Creating vehicule
//		Vehicule vehicule = new Vehicule(
//				/*
//				 * String color, String mark, String model, String year, String power, String
//				 * numberPlate, String photo
//				 */
//
//				vehiculeRequest.getColor(), vehiculeRequest.getMark(), vehiculeRequest.getModel(),
//				vehiculeRequest.getYear(), vehiculeRequest.getPower(), vehiculeRequest.getNumberplate(),
//				vehiculeRequest.getPicture());
//
//		User mUser = userRepository.findUserById(vehiculeRequest.getUserId());
//
//		// user's vehicules
//		Set<Vehicule> userVehicules = mUser.getVehicules();
//		Set<Vehicule> vehicules = new HashSet<>();
//
//		// fill vehicule table
//		Vehicule savedVehicule = vehiculeRepository.save(vehicule);
//		vehicules.add(savedVehicule);
//		userVehicules.forEach(v -> {
//			vehicules.add(v);
//		});
//
//		// register vehicules for this user
//		mUser.setVehicules(vehicules);
//
//		// save the user
//		userRepository.save(mUser);
//
//		return ResponseEntity.ok(new Gson().toJson(savedVehicule));
//	}
}

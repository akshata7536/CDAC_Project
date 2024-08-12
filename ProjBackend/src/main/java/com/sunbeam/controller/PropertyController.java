package com.sunbeam.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sunbeam.DTO.ApiResponse;
import com.sunbeam.DTO.PropertyDTO;
import com.sunbeam.entities.Property;
import com.sunbeam.services.PropertyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;



    @GetMapping("/getPropertyById/{id}")
    public ResponseEntity<?> getProperty(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(propertyService.getProperty(id));
		}
		catch(RuntimeException e){
			System.out.println("error"+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
		}
		
		   @GetMapping("/allProperty")
		    public ResponseEntity<?> getAllProperty(){
				try {
					return ResponseEntity.status(HttpStatus.OK).body(propertyService.getAllProperties());
				}
				catch(RuntimeException e){
					System.out.println("error"+e);
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
				}

    }
    
  
    @PostMapping("/addProperty/{id}")
    public ResponseEntity<Property> createProperty(@RequestBody PropertyDTO propertyDTO,@PathVariable Long id) {
        try {
        	System.out.println(propertyDTO);
            Property savedProperty = propertyService.addProperty(propertyDTO,id);
            return ResponseEntity.ok(savedProperty);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

 
    public ResponseEntity<?> updateProperty(@RequestBody PropertyDTO propertyDTO,@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(propertyService.updateProperty(propertyDTO, id));
		}
		catch(RuntimeException e){
			System.out.println("error"+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
    
}
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProperty(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(propertyService.deleteProperty(id));
		}
		catch(RuntimeException e){
			System.out.println("error"+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
    
    }
    
    
	@GetMapping("/allPropertiesByOwnerId/{id}")
	public ResponseEntity<?> getOwner(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(propertyService.getAllProp(id));
		}
		catch(RuntimeException e){
			System.out.println("error"+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
    
    
    


}


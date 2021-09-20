package br.com.evergreenapi.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.evergreenapi.Domain.Profile;
import br.com.evergreenapi.Repositories.ProfileRepository;

@RestController
@RequestMapping(value = "/api/v1/profiles")
public class ProfilesController {
    @Autowired
    ProfileRepository profile;
    
    @RequestMapping(value = "")
	public List<Profile> profile() {
		return (List<Profile>) profile.findAll();
	}
}

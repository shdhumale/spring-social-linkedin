package hello;

import javax.inject.Inject;

import org.springframework.social.connect.UserProfile;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.LinkedInProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

    /*private Twitter twitter;

    private ConnectionRepository connectionRepository;

    @Inject
    public HelloController(Twitter twitter, ConnectionRepository connectionRepository) {
        this.twitter = twitter;
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String helloTwitter(Model model) {
        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
            return "redirect:/connect/twitter";
        }

        model.addAttribute(twitter.userOperations().getUserProfile());
        CursoredList<TwitterProfile> friends = twitter.friendOperations().getFriends();      
        model.addAttribute("friends", friends);
        return "hello";
    }*/
	
	private LinkedIn linkedin;

	UserProfile userProfile;

	@Inject
	public HelloController(LinkedIn linkedin) {
	    this.linkedin = linkedin;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String helloLinkedIn(Model model) {
		try {
	    if (!linkedin.isAuthorized()) {
	        return "redirect:/connect/linkedin";

	    }}catch (NullPointerException e){
	        return "redirect:/connect/linkedin";
	    }



	    LinkedInProfile profile = linkedin.profileOperations().getUserProfile();

	    String profileId = linkedin.profileOperations().getProfileId();
	System.out.println(profileId);


	    return "hello";
	}

}

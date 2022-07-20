package sg.edu.nuss.iss.d13workshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nuss.iss.d13workshop.models.Contact;
import sg.edu.nuss.iss.d13workshop.services.DatabaseService;

@Controller
@RequestMapping(path = "/contact")
public class ContactController {
    
    // instantiate the DatabaseService class
    @Autowired
    private DatabaseService db5vc;

    // functions
    // Model model is for injection, if needed
    // @RequestBody means read the request from the body of client, which is the form content
    @PostMapping(consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String postContact(@RequestBody MultiValueMap<String, String> form, Model model) {

        Contact c = new Contact();
        c.setName(form.getFirst("name"));
        c.setEmail(form.getFirst("email"));
        c.setPhone(form.getFirst("phone"));

        System.out.printf("Contact %s: ", c);
        
        // save to database
        db5vc.save(c);

        model.addAttribute("contact", c);

        return "showcontact";
    }

    @GetMapping(value="/{id}", produces="text/html")
    public String getContact(@PathVariable("id") String id, Model model) {
        
        Contact c = new Contact();

        c = db5vc.read(id);
        System.out.printf("> id: %s", c);

        model.addAttribute("contact", c);
        return "showcontact";

        
    }

}

// // package com.CollabFusion.COLLABFUSIONPROEJCT.controllers;
// // import java.util.List;
// // import org.hibernate.mapping.List;
// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.stereotype.Controller;
// // import org.springframework.web.bind.annotation.GetMapping;
// // import org.springframework.web.bind.annotation.RequestMapping;
// // import com.CollabFusion.COLLABFUSIONPROEJCT.models.Contributor;
// // import com.CollabFusion.COLLABFUSIONPROEJCT.repositories.contributorRepository;
// // import ch.qos.logback.core.model.Model;
// // @Controller 
// // @RequestMapping("/details")
// // public class ContributorController{
// //     @Autowired
// //     private contributorRepository repo;
// //     @GetMapping
// //     public String getContributors(Model model) {
// //         List<Contributor> details = repo.getContributor();
// //         model.addAttribute("details", details);
// //         return "details/index";
// //     }
// // }
// package com.CollabFusion.COLLABFUSIONPROEJCT.controllers;
// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import com.CollabFusion.COLLABFUSIONPROEJCT.models.Client;
// import com.CollabFusion.COLLABFUSIONPROEJCT.repositories.ClientsRepository;
// @Controller
// @RequestMapping("/clients")
// public class ClientsController {
//     @Autowired
//     private ClientsRepository repo;
//     @GetMapping
//     public String getClients(Model model) {
//         List<Client> clients = repo.getClients();
//         model.addAttribute("clients", clients);
//         return "clients/index";
//     }
// }
package com.CollabFusion.COLLABFUSIONPROEJCT.controllers;

import com.CollabFusion.COLLABFUSIONPROEJCT.models.Client;
import com.CollabFusion.COLLABFUSIONPROEJCT.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientsRepository repo;

    @GetMapping
    public String getClients(Model model) {
        List<Client> clients = repo.getClients();
        model.addAttribute("clients", clients);
        return "clients/index";
    }
}

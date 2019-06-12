package inventory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	//http://localhost:8080/inventory/hello
	@GetMapping("/hello")
	public String index() {
		return "index";
	}
}

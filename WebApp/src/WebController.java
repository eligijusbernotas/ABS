import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import BaluSistema.Kursas;

@Controller
public class WebController {

	@RequestMapping(value = "studKursai")
	@ResponseBody
	public List<Kursas> StudentoKursai(){
		return null;
	}
}

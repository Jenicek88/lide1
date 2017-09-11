package cz.honza.test.demo.lide;

import java.util.List;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;

@RestController
public class ClovekController {
	private ClovekRepository lide;
	
	@Autowired
	public ClovekController(ClovekRepository lide) {
		super();
		this.lide = lide;
	}



	@RequestMapping(value="/ahoj",produces=MediaType.TEXT_PLAIN_VALUE)
	public String ahoj() {
		return "Blabla";
	
	}
	
	@RequestMapping(value="/lide",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Clovek> lide() {
		 return lide.najdiVsechnyLidi();
	//stream().map(c -> c.getJmeno()).collect(Collectors.toList())
		 
	
	}
	 @RequestMapping(value="/clovek/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
		public Clovek najdiClovek(@PathVariable Integer id) {
			 return lide.najdiClovek(id);
		//stream().map(c -> c.getJmeno()).collect(Collectors.toList())
	 }
	 
	 @RequestMapping(value="/clovek",method=RequestMethod.POST)
		public void najdiClovek(@RequestBody Clovek clovek ) {
			lide.save(clovek);
		
	 }
	 @RequestMapping(value="/najdipodlejmena",method=RequestMethod.GET)
	 public List<Clovek> najdiPodleJmenaAPrijmeni(@RequestParam(value="jmeno")String jmeno,@RequestParam(value="prijmeni")String prijmeni) {
		 return lide.najdiPodleJmenaAPrijmeni( jmeno, prijmeni);
	 }
	 
	 @RequestMapping(value="/najdipodlejmena",method=RequestMethod.POST)
	 public List<Clovek> najdiPodleJmenaAPrijmeni2(@RequestParam(value="jmeno")String jmeno,@RequestParam(value="prijmeni")String prijmeni) {
		 return lide.najdiPodleJmenaAPrijmeni( jmeno, prijmeni);
	 }
	 
	 @RequestMapping(value="/najdipodleveku",method=RequestMethod.POST)
	 public List<Clovek> najdiPodleVeku(@RequestParam(value="vek")Integer vek) {
		 return lide.najdiPodleVeku( vek);
	 }
	
	 @RequestMapping(value="/najdipodlevekuapohlavi",method=RequestMethod.POST)
	 public List<Clovek> najdiPodleVekuAPohlavi(@RequestParam(value="vek")Integer vek,@RequestParam(value="pohlavi")String pohlavi) {
		 return lide.najdiPodleVekuAPohlavi(vek, pohlavi);
	 }
	 
	 @RequestMapping(value="/login",method=RequestMethod.GET)
	 public List<Clovek> najdiPodleHesla(@RequestParam(value="heslo")String heslo,@RequestParam(value="nick")String nick) {
		 return lide.najdiPodleHesla(heslo, nick);
	 }
	 
	 @RequestMapping(value="/loginnick",method=RequestMethod.GET)
	 public List<Clovek> najdiPodleNick(@RequestParam(value="nick")String nick) {
		 return lide.najdiPodleNick(nick);
	 }

	
}

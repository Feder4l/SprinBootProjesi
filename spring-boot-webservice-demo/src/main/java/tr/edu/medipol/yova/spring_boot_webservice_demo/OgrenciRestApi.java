package tr.edu.medipol.yova.spring_boot_webservice_demo;

import java.util.*;
import org.springframework.web.bind.annotation.*;


@RestController                    
@RequestMapping("/ogrenci")       
public class OgrenciRestApi {
	
	public record Ogrenci (String numara, String name){}

    private static List<Ogrenci> OGRENCILER = new ArrayList<>();
    static {
        OGRENCILER.add(new Ogrenci("1","selçuk"));
        OGRENCILER.add(new Ogrenci("1","federal"));
    }
   
    @GetMapping("/")
    public List<Ogrenci> listele() {
        return OGRENCILER;
        
    }
    
    @PostMapping("/")
    public void ekle(Ogrenci yeniOgrenci) {
    	OGRENCILER.add(yeniOgrenci);
    }
    @DeleteMapping("/")
    public boolean sil(@RequestParam String numara) {
    	for(Ogrenci ogrenci: OGRENCILER) {
    		if(ogrenci.numara.equals(numara)) {
    			OGRENCILER.remove(ogrenci);
    			return true;
    		}
    	}
    	
    	return false;
    }
}
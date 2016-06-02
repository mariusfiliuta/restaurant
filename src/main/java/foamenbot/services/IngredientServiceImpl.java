package foamenbot.services;

import foamenbot.model.Ingredient;
import foamenbot.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class IngredientServiceImpl implements  IngredientService{

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> findAll(){ return ingredientRepository.findAll();}
    @Override
    public Ingredient findByName(String name){ return ingredientRepository.findByName(name);}
    @Override
    public void save(Ingredient ingredient){ ingredientRepository.save(ingredient);}
    @Override
    public void delete(Ingredient ingredient){ ingredientRepository.delete(ingredient);}
    @Override
    public Ingredient findById(long id){ return ingredientRepository.findById(id);}

    @Override
    public int doPostAndReturnHTTPStatus(String ingredientName, int quantity) {

        try {
            String url = "http://localhost:8081/getIngredient/" + ingredientName + '/' + quantity;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            return con.getResponseCode();
        }
        catch(Exception ex) {
            return 500;
        }
    }
}

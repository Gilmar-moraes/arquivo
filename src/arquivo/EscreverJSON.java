package arquivo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class EscreverJSON {

	public static void main(String[] args) throws IOException {
		
		Usuario usuario1 = new Usuario();
		usuario1.setLogin("Gilmar12");
		usuario1.setSenha("123");
		usuario1.setCpf("01399925207");
		usuario1.setNome("Gilmar Moraes");
		
		Usuario usuario2 = new Usuario();
		usuario2.setLogin("Gilmara12");
		usuario2.setSenha("456");
		usuario2.setCpf("01399925212");
		usuario2.setNome("Gilmara Moraes");
		
		List<Usuario> listaUsuarios = new ArrayList<>();
		listaUsuarios.add(usuario1);
		listaUsuarios.add(usuario2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonUser = gson.toJson(listaUsuarios);
		System.out.println(jsonUser);
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\Junior\\eclipse-workspace\\arquivo\\src\\arquivo\\filerjson.json");
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();
		
		//----------------------------------LENDO O ARQUIVO JSON----------------------------------//
		
		FileReader fileReader = new FileReader("C:\\Users\\Junior\\eclipse-workspace\\arquivo\\src\\arquivo\\filerjson.json");
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);
		
		List<Usuario> lista2Usuarios = new ArrayList<>();
		
		for (JsonElement jsonElement : jsonArray) {
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			lista2Usuarios.add(usuario);
		}
		System.out.println("Leitura do arquivo JSON: " +lista2Usuarios);
	}
}

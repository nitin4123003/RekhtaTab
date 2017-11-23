package Chrome.RekhtaTab.resources;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Chrome.RekhtaTab.api.Sher;


@Path("getContent")
@Produces(MediaType.APPLICATION_JSON)
public class SherResource {

    private static Integer globalCounter = 0;

    @GET
    public Response allEvents() {


        BufferedReader br = null;
        FileReader fr = null;

        try {
            String fileName = "D:\\Corpus.txt";
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            String sCurrentLine = "";

            Integer NUM_OF_LINES = (int) Files.lines(Paths.get(fileName)).count();
            System.out.println(NUM_OF_LINES);
            globalCounter = (globalCounter + 1) % (NUM_OF_LINES + 1);
            globalCounter = globalCounter == 0 ? 1 : globalCounter;
            System.out.println("Global Counter=" + globalCounter);
            int curCounter = 0;
            while (curCounter != globalCounter) {
                sCurrentLine = br.readLine();
                curCounter++;
            }
            return Response.ok() // 200
                    .entity(new Sher(sCurrentLine)).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS")
                    .build();
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return Response.ok() // 200
                .entity("Error occured").header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
    }
}


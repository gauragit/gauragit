import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.parser.ParseException;


public class UrlReader
{

    public static void main(String[] args)
    {
        UrlReader urlReader = new UrlReader();

        for (String url : args)
	    {
            try
		{
		    String year = "";
		    // url = "http://www.wsnl.net/hist/WSN2013.htm";
		    String contents = urlReader.readContents(url);
		    System.out.printf("url: %s contents: %s\n", url, contents);
		}
            catch (Exception e)
		{
		    e.printStackTrace();
		}
	    }
    }


    public String readContents(String address) throws IOException, ParseException, InterruptedException
    {
	int start = 0; 
        StringBuilder contents = new StringBuilder(4048000);
        BufferedReader br = null;
        String[] parts = address.split("/");
	
	int len = parts.length - 1;
	parts[len] = parts[len].replaceAll("\\D+","");
        PrintWriter writer = new PrintWriter("/Users/user/Desktop/"+parts[len]+".txt", "UTF-8");
        final Pattern tags = Pattern.compile("<.+?>");
        
        try
	    {
		
		
		
		writer.println("Temples,Country,Points,Change,Maha Big Books,Big Books,Medium Books,Small Books,Mags,BTG Subs,Full Sets,"
			       + "Latitude,Longitude,Year");
		
		String x = null ;
		
		
		
		Hashtable thash = new Hashtable();

		// String str;
		// String bal;

		String arr[] ={"Moscow-JagannatRus","SankirtanDham", "RupanugaVedicCoUSA","SimhacalamNJN",
			       "CueramaroMex","Sydney-NorthAus","PermRus","Moscow-BhaktiveRus","NovorosiyskRus",
			       "SofiaBul","GovindadvipaIre","Chittagong-PrabBan","HersonUkr","BhaktilokaSVK",
			       "VrajabhumiBra","SpainBBT","Francoda","Riode","SkudaiMal", "SerembanMal", "NavalKunda",
			       "SandtonSA","Bukit-MertajamMal", "CampinaGrande", "ThailandTSKP",
			       "PortugalBBT","JeleznogorskRus","RybinskRus","ArielIsr","PietermaritzburSA",
			       "ShuiRus","GauraVrndavana","BlantyreMal","Taiping493.00", "AlorSetar",
			       "VinnizaUkr", "VladimirRus", "N-TagilRus", "KurganRus", "GolokaDhama",
			       "SaranagatiFarm","UruapanMex","AnnHarbor", "NikolaevUkr","MafikengSA",
			       "SplitCro","BeninNig","NatalBra", "Komsomolsk-on-ARus","BrazilTSKP",
			       "UzgorodUkr","KuantanMal","Kluang36.00","BalkhashKaz"};
		      
		String arr_val[] ={"iskcon+moscow","iskcon+florence","rupanuga+vedic+college","jandelsbrunn",
				   "Guanajuato+Mexico","ISKCON+North+Sydney+NSW","perm+russia","iskcon+moscow",
				   "iskcon+Novorosiysk","iskcon+sofia+bulgaria","Derrylin+ireland",
				   "iskcon+baltimore","iskcon+Chittagong","ISKCON+Kherson","ISKCON+Bratislava",
				   "Teresopolis+Friburgo+Rio+de+Janeiro+Brazil","iskcon+madrid",
				   "Franco+da+Rocha+Sao+Paulo+Brazil","iskcon+Rio+de+Janeiro",
				   "Skudai+Johor+Darul+Takzim+Malaysia","Seremban+Negeri+Sembilan+Malaysia",
				   "iskcon+barcelona","rivonia+standton","iskcon+bukit-mertajam+malay",
				   "Campina+Grande","Thonburi+Bangkok","portugal","iskcon+zheleznogorsk+russia",
				   "Rybinsk+Russia","iskcon+ariel+israel","Pietermaritzbur+South+Africa",
				   "Shui+Russia","Gaura+Vrndavana","Blantyre+Malawi","Taiping","AlorSetar",
				   "Vinniza+ukraine","iskcon+vladimir+russia","N-Tagil+Russia","Kurgan+Russia",
				   "Abentheuer+Germany","Ashcroft+British+Columbia+Canada","iskcon+uruapan+mexico",
				   "Ann+Harbor","nikolaev+ukraine","Mafikeng+south+africa","iskcon+split+croatia",
				   "Benin+nigeria","natal+brazil","iskcon+Komsomolsk+Russia",
				   "Pindamonhangaba+Sao+Paulo+Brazil","iskcon+Uzhgorod+Ukraine","iskcon+kuantan+malaysia",
				   "iskcon+Kluang+malaysia","Balkhash+Kazakhstan"};
		      
		for(int i=0; i< arr.length; i++){
		          
		    thash.put(arr[i], new String(arr_val[i]));
		    //thash.put(arr[i], new String());
		          
		}
		
		//System.out.println(((String)thash.get(arr[0])).toString());
		
   
   
		URL url = new URL(address);
		br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = " ";
		
		while (line != null){
		    
		    line = br.readLine();
                
                
		    if ((line.length() > 0))  { 
			
                
			if((start == 2) && (line.contains("Change compared"))){
			    
			    break;
			}
			if(line.contains("TEMPLES (CUMULATIVE)")){
			    System.out.println("compared ! " + line);
			    start = 1;
			}
			
			
			line = line.replaceAll("<[^>]*>", ""); 
			//line = line.replaceAll("\\(\\w+\\)|\\)|\\(|[W][e][b]|[+]|[%]|[(][M]", " ");
                
			line = line.replaceAll("\\( \\w+\\)|\\)|\\(\\w+\\)|\\)|\\(|[W][e][b]|[+]|[%]|[(][M]", " ");
			line = line.replaceAll("\\sM\\s","");
			line = line.replaceAll("\\sMS\\s","");
			line = line.replaceAll("\\sS\\s","");
                
			if ((line.length() > 0) && (line.charAt(line.length()-1)=='*')) {
			    line = line.substring(0, line.length()-1);
			}
               
			//Change compared to
			//COUNTRIES (CUMULATIVE)
			//when 1 starts
			//    char c = line.charAt(0);
			//    boolean isDigit = (c >= '0' && c <= '9');
			//line.substring(1);
			// writer.println(line.substring(2));
		    }
		    contents.append(line);
		    contents.append("\t");
		    //System.out.println(line);
		    
		    if(start ==1){
			if( (start ==1) && ((line.contains("Mayapur")) 
					    || (line.contains("Delhi")) ||(line.contains("Mumbai")))){
			    start = 2;
			}
		    }
		    int first_token = 0;
		    String store_first = null;
		    String store_second = null;
		    String location = null;
		        
		    if(start ==2){
			line = line.replace(' ', '*');
			//line = line.replace("*", ",");
			StringTokenizer  st = new StringTokenizer(line,"*");
			st.nextElement();
			while(st.hasMoreTokens() )
			    {  
				if(first_token == 0) {
				    store_first = (String) st.nextElement();
				    writer.print(store_first +",");
				    
				    JsonReader jr = new JsonReader();
				    location = jr.getlocation("iskcon"+"+"+store_first);
				    //Thread.sleep(1000);
				    if(location !="0") {
					//System.out.println("nulll  \n");
					// System.out.println("location first hit "+location);
				    }
				}
				if(first_token == 1) {
				     
				    store_second = (String) st.nextElement();
				        
				    writer.print(store_second +",");
				    // System.out.print("????? "+store_first+ " " +store_second);
				    if(location =="0"){
					// System.out.println("second \n");
					//System.out.print("????? "+store_first+ " " +store_second);
					JsonReader jr = new JsonReader();
					location = jr.getlocation("iskcon" + "+" +store_first+ "+" +store_second);
					if(location !="0")
					    ;
					//System.out.println("location second hit "+location);
					//else
					//System.out.println("could not find"); 
				    }
				      
				}
				if(first_token >1) {
				    writer.print(st.nextElement()+",");
				}
				first_token++;
				
				
			    }
			
			String[] loc_result = location.split(" ");
			if(location !="0") {
			    writer.print(loc_result[0] +",");
			    writer.print(loc_result[1]+",");
			} else {
			    
			    JsonReader jr = new JsonReader();
			    
			    location = jr.getlocation((String) (thash.get(store_first+store_second)));
			    System.out.println("hashing for "+thash.get(store_first+store_second) +" "+ location);
			    if(thash.get(store_first+store_second) != null &&(location !="0")) {
				//System.out.println("look at this !!!!!");
				loc_result= null;
				loc_result = location.split(" ");
				writer.print(loc_result[0] +",");
				writer.print(loc_result[1]+",");
				//hashing for null 44.8923555 -116.0934513
				System.out.println("loc result is "+ loc_result[0] +" "+loc_result[1]);
			    } else {
				writer.print("nodata-lat" +",");
				writer.print("nodata-lon"+",");
			    }
			}
			writer.print(parts[len]);
			writer.println();
		    }
		    
		}
	    }
        finally
	    {
		writer.close();
		close(br);
	    }

        return contents.toString();
    }

    private static void close(Reader br)
    {
        try
	    {
		if (br != null)
		    {
			br.close();
		    }
	    }
        catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }
}

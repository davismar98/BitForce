/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalityinsightsdemo;

import Modelo.Perfil;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Trait;

public class GetInsights {

  private static String textToAnalyze =
    "Un día tú me prometiste que cualquier cosa que yo hiciera, tú la comprenderías y me darías la razón. Por favor, trata de entender mi muerte. Yo no estaba hecho para vivir más tiempo. Estoy enormemente cansado, decepcionado y triste, y estoy seguro de que cada día que pase, cada una de estas sensaciones o sentimientos me irán matando lentamente. Entonces prefiero acabar de una vez.\n" +
"\n" +
"De ti no guardo más que cariño y dulzura. Has sido la mejor madre del mundo y yo soy el que te pierdo, pero mi acto no es derrota. Tengo todas las de ganar, porque estoy convencido de que no me queda otra salida. Nací con la muerte adentro y lo único que hago es sacármela para dejar de pensar y quedar tranquilo.\n" +
"\n" +
"…Acuérdate solamente de mí. Yo muero porque ya para cumplir 24 años soy un anacronismo y un sinsentido, y porque desde que cumplí 21 vengo sin entender el mundo. Soy incapaz ante las relaciones de dinero y las relaciones de influencias, y no puedo resistir el amor: es algo mucho más fuerte que todas mis fuerzas, y me las ha desbaratado.\n" +
"\n" +
"…Dejo algo de obra y muero tranquilo. Este acto ya estaba premeditado. Tú premedita tu muerte también.\n" +
"\n" +
"Es la única forma de vencerla.\n" +
"\n" +
"Madrecita querida, de no haber sido por ti, yo ya habría muerto hace ya muchos años. Esta idea la tengo desde mi uso de razón. Ahora mi razón está extraviada, y lo que hago es solamente para parar el sufrimiento.";

  private static String data =
    "{\"textToAnalyze\": \"" + textToAnalyze + "\"," +
    " \"username\"     : \"b8363796-2cfd-4200-bd1f-0883a500ce51\"," +
    " \"password\"     : \"Q8RbaMVVIEoI\"," +
    " \"endpoint\"     : \"https://gateway.watsonplatform.net/personality-insights/api\"," +
    " \"skip_authentication\" : \"true\"}";
  
  
    public double apertura_experiencias;
    private float responsabilidad;
    private float extroversion;
    private float amabilidad;
    private float rango_emocional;
    //necesidades
    private float desafio;
    private float curiosidad;
    private float entusiasmo;
    private float ideal;
    private float autoexpresion;
    private float estabilidad;
    //valores
    private float superacion_personal;

  public static void main(String[] args) {
    JsonParser parser = new JsonParser();
    JsonObject jsonArgs = parser.parse(data).getAsJsonObject();
    main(jsonArgs);
  }

  public static JsonObject main(JsonObject args) {
    JsonParser parser = new JsonParser();

   
    PersonalityInsights service = new
            PersonalityInsights("2017-10-13");
    //PersonalityInsights(PersonalityInsights.VERSION_DATE_2016_10_19);
            
    service.setUsernameAndPassword(args.get("username").getAsString(),
                                   args.get("password").getAsString());

    if (args.get("endpoint") != null)
      service.setEndPoint(args.get("endpoint").getAsString());

    if (args.get("skip_authentication") != null)
      service.setSkipAuthentication((args.get("skip_authentication")
        .getAsString() == "true") ? true : false);
    
   
    Profile result =
            
      service.getProfile(args.get("textToAnalyze").getAsString()).execute();
     

    System.out.println("Watson's analysis\n\nComment: " +
                       result.getWordCountMessage() + "\n");
    
    double apertura_experiencias = 1;
    double responsabilidad = 1;
    double extroversion = 1;
    double amabilidad = 1;
    double rango_emocional = 1;
    //necesidades
    double desafio = 1;
    double curiosidad = 1;
    double entusiasmo = 1;
    double ideal = 1;     
    double autoexpresion = 1;
    double estabilidad = 1;
    //valores
    double superacion_personal = 1;

    System.out.println("Personality traits:");
    List<Trait> traits = result.getPersonality();
    for (Trait nextTrait : traits) {
      System.out.println("- " + nextTrait.getName() + " - (" +
                         (int) (nextTrait.getPercentile() * 100) +
                         " percentile) -- " + nextTrait.getTraitId());
      
      //Verificamos si el Trait es un Insight útil 
      if(nextTrait.getTraitId().equals("big5_openness")){
          apertura_experiencias = nextTrait.getPercentile();
      }
      if(nextTrait.getTraitId().equals("big5_conscientiousness")){
          responsabilidad = nextTrait.getPercentile();
      }
      if(nextTrait.getTraitId().equals("big5_extraversion")){
          extroversion = nextTrait.getPercentile();
      }
      if(nextTrait.getTraitId().equals("big5_agreeableness")){
          amabilidad = nextTrait.getPercentile();
      }
      if(nextTrait.getTraitId().equals("big5_neuroticism")){
          rango_emocional = nextTrait.getPercentile();
      }
      
    }
    System.out.println("\nEmotional needs:");
    List<Trait> needs = result.getNeeds();
    for (Trait nextNeed : needs) {
      System.out.println("- " + nextNeed.getName() + " - (" +
                         (int) (nextNeed.getPercentile() * 100) +
                         " percentile) -- " + nextNeed.getTraitId());
      /*
    //valores
    double superacion_personal = 1;
      
      */
      //Verificamos si el Need es un Insight útil 
      if(nextNeed.getTraitId().equals("need_challenge")){
          desafio = nextNeed.getPercentile();
      }
      if(nextNeed.getTraitId().equals("need_curiosity")){
          curiosidad = nextNeed.getPercentile();
      }
      if(nextNeed.getTraitId().equals("need_excitement")){
          entusiasmo = nextNeed.getPercentile();
      }
      if(nextNeed.getTraitId().equals("need_ideal")){
          ideal = nextNeed.getPercentile();
      }
      if(nextNeed.getTraitId().equals("need_self_expression")){
          autoexpresion = nextNeed.getPercentile();
      }
      if(nextNeed.getTraitId().equals("need_stability")){
          estabilidad = nextNeed.getPercentile();
      }
      
      
    }
    System.out.println("\nPersonal values:");
    List<Trait> values = result.getValues();
    for (Trait nextValue : values) {
      System.out.println("- " + nextValue.getName() + " - (" +
                         (int) (nextValue.getPercentile() * 100) +
                         " percentile) -- " + nextValue.getTraitId());
      
      
      //Verificamos si el Need es un Insight útil 
      if(nextValue.getTraitId().equals("value_self_enhancement")){
          superacion_personal = nextValue.getPercentile();
      }
    }
    
    /*
     double apertura_experiencias = 1;
    double responsabilidad = 1;
    double extroversion = 1;
    double amabilidad = 1;
    double rango_emocional = 1;
    //necesidades
    double desafio = 1;
    double curiosidad = 1;
    double entusiasmo = 1;
    double ideal = 1;     
    double autoexpresion = 1;
    double estabilidad = 1;
    //valores
    double superacion_personal = 1;
    */
    
    Perfil p = new Perfil(apertura_experiencias,responsabilidad,extroversion,amabilidad,rango_emocional,desafio,curiosidad
    ,entusiasmo, ideal, autoexpresion, estabilidad, superacion_personal);
    
    double resultado = p.getResultado();
    
    System.out.println(p.toString());
    System.out.println("\n\nProbabilidad de deserción basada en su personalidad: " + resultado*100 + "%");

    JsonObject returnObject = parser.parse(result.toString()).getAsJsonObject();
    return returnObject;
  }
}
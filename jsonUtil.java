import net.sf.json.JSONObject;
import java.util.String ;
public class jsonUtil {
	public static String convertMaptoJsonString(Map<String ,Object> result){
    String resultStr = JSONObject.fromObject(result).toString();
	}
  
  public static void readJson2Map(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
 
            //将json字符串转成map结合解析出来，并打印(这里以解析成map为例)
            Map<String, Map<String, Object>> maps = objectMapper.readValue(
                    json, Map.class);
            System.out.println(maps.size());
            Set<String> key = maps.keySet();
            Iterator<String> iter = key.iterator();
            while (iter.hasNext()) {
                String field = iter.next();
                System.out.println(field + ":" + maps.get(field));
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


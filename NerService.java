/*
   <dependency>
    	<groupId>org.apache.httpcomponents</groupId>
        <artifactId>httpclient</artifactId>
        <version>4.5.2</version>
    </dependency>
    <dependency>
            <groupId>net.sf.json-lib</groupId>
            <artifactId>json-lib</artifactId>
            <version>2.4</version>
            <classifier>jdk15</classifier>
    </dependency>

*/

 private final  ResponseHandler<String> responseHandler         = new AbstractResponseHandler<String>() {
                                                                        @Override
                                                                        public String handleEntity(final HttpEntity entity) throws IOException {
                                                                            return EntityUtils.toString(entity, "utf-8");
                                                                        }
                                                                     };
    private String url = "http://47.94.131.2/xulie/car?sent= ";                     
    private static HttpClient httpClient = HttpClients.createDefault();
    
    public NerService() {
    	
    }
    
    public List<NerEntity> evaluate(String sentence) {
    	JSONObject nerObject = null;
    	sentence=sentence.replaceAll(";", " ");
    	sentence=sentence.replaceAll("；", " ");
    	HttpGet tokenGet = new HttpGet(url+URLEncoder.encode(sentence));
        String tokenBody = "";
        try {
            tokenBody = this.httpClient.execute(tokenGet, this.responseHandler);
            if(tokenBody != null) {
            	nerObject = JSONObject.fromObject(tokenBody);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        List<NerEntity> entities = new ArrayList<>();
        if(nerObject.containsKey("entities")) {
        	JSONArray array = (JSONArray) nerObject.get("entities");
        	for(int i=0;i<array.size();i++) {
        		JSONObject o = (JSONObject) array.get(i);
        		entities.add(
        				new NerEntity((Integer)o.get("start"),
        						(Integer)o.get("end"),
        						Integer.valueOf((String)o.get("type")),
        						(String)o.get("word")));
        	}
        }
        return entities;
    }

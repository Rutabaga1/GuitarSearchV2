package guitar.model;
public class GuitarSpec {
 
  private String builder; 
  private String color;
  private String type;
  private String numStrings;
  //private Wood backWood;
  //private Wood topWood;

  public GuitarSpec(String builder, String type,
		  String numStrings, String color) {
    this.builder = builder;
    this.color = color;
    this.type = type;
    this.numStrings = numStrings;
    //this.backWood = backWood;
    //this.topWood = topWood;
  }

  public String getBuilder() {
    return builder;
  }

  public String getType() {
    return type;
  }

  public String getNumStrings() {
	    return numStrings;
	  }

  public String getColor() {
	return color;
  }

  public boolean matches(GuitarSpec otherSpec) {
	if(!otherSpec.builder.equals("allBuilder")){  
		if (!builder.equals(otherSpec.builder))
			return false;
	}
    
	if(!otherSpec.type.equals("")){
		int i=0;
		char gType[]=type.toCharArray();//针对汉语
		char IType[]=otherSpec.type.toCharArray();
		labe1:for (int j = 0; j < gType.length; j++) {
			for (int k = 0; k < IType.length; k++) {
				if(IType[k]==gType[j]){//容错性或者相似性比较
					i++;
					break labe1;
				}
			}}
		if (i==0)
			return false;
	}
	
	if(!otherSpec.numStrings.equals("")){
		if (!numStrings.equals(otherSpec.numStrings) )
			return false;
	}
	
	if(!otherSpec.color.equals("")){
		int q=0;
		char gColor[]=color.toCharArray();
		char IColor[]=otherSpec.color.toCharArray();
		labe2:for (int j = 0; j < gColor.length; j++) {
			for (int k = 0; k < IColor.length; k++) {
				if(IColor[k]==gColor[j]){//容错性或者相似性比较
					q++;
					break labe2;
				}
			}}
    
		if (q==0)
			return false;
    }
   
    return true;
  }

    


}

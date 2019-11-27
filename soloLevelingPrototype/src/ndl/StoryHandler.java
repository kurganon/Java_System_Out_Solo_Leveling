package ndl;

public class StoryHandler {
	private static final StoryHandler stHandler = new StoryHandler();
	
	public StoryHandler() {
		
	}
	
	public String getShoutOut(int index) {
		switch(index) {
			case 1000000 : return "todo SO: #" + index;
			
			case 3 : return "TD";
			
			case 2 : return "TD";
			
			case 1 : return "TD";
				
			case 0 : return "TD";
			default: return "todo SO: #" + index;
		}
	}
	
	/**
	 * 
	 * @param chapter
	 * @param index
	 * @return
	 */
	public String getDialog(int chapter, int index) {
		switch(chapter) {
			case 1000000 : return "todo chapter " + chapter;
			
			case 3 : return chapter3(index);
			
			case 2 : return chapter2(index);
			
			case 1 : return chapter1(index);
				
			case 0 : return prologue(index);
			default: return "todo chapter " + chapter;
		}
	}
	
	public String prologue(int index) {

		switch(index) {
			case 1000000 : return "todo prologue/" + index;
			
			case 3 : return "";
			
			case 2 : return "";
			
			case 1 : return "";
				
			case 0 : return "";
			default: return "todo prologue/" + index;
		}
	}
	
	public String chapter1(int index) {

		switch(index) {
			case 1000000 : return "todo prologue/" + index;
			
			case 3 : return "";
			
			case 2 : return "";
			
			case 1 : return "";
				
			case 0 : return "";
			default: return "todo prologue/" + index;
		}
	}
	
	public String chapter2(int index) {

		switch(index) {
			case 1000000 : return "todo prologue/" + index;
			
			case 3 : return "";
			
			case 2 : return "";
			
			case 1 : return "";
				
			case 0 : return "";
			default: return "todo prologue/" + index;
		}
	}
	
	public String chapter3(int index) {

		switch(index) {
			case 1000000 : return "todo prologue/" + index;
			
			case 3 : return "";
			
			case 2 : return "";
			
			case 1 : return "";
				
			case 0 : return "";
			default: return "todo prologue/" + index;
		}
	}
	
	public static StoryHandler getStoryHandler() {
		return StoryHandler.stHandler;
	}
}

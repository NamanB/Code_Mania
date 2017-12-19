package scripts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Script {
	
	public String name;
	public String[] script;
	public int currentLine = 2;
	public int runCount = 0;
	public int maxRuns = 1;
	public boolean doesRepeat = false;
	
//	Script format
//	name
//	repeat=forever;repeat=count ignore all spaces in this line
//	<script>
	
	public Script(String scriptName) {
		readFile("/Scripts/" + scriptName + ".txt");
		this.name = this.script[0];
		this.script[1].replaceAll(" ", "");
		if (this.script[1].indexOf("repeat=") != -1 && (Integer.parseInt(this.script[1].substring(7)) > 0)) {
			//get int from string if it exists and save into max runs
			try {
				this.maxRuns = Integer.parseInt(this.script[1].substring(7));
			} catch (NumberFormatException e) {
				System.out.println("invalid repeat count in " + this.name);
			}
		}
	}

	private void readFile(String filePath) {
		// TODO Auto-generated method stub
		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		script = content.split("\n");
		
		for (int i = 0; i < script.length; i++) {
			script[i].trim();
		}
		
		System.out.println(content);			//for test purposes
	}

	private String readNextLine() {
		if (currentLine < script.length) {
			currentLine++;
			return script[currentLine-1];
		}
		return "Script finished!";
	}
	
	
}

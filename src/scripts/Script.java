package scripts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Script {

	public String name;
	public String[] script;
	public int currentLine = 1;
	public int runCount = 0;
	public int maxRuns = 1; // -1 repeat forever
	public boolean doesRepeat = false;

	// Script format
	// name
	// repeat=forever;repeat=count ignore all spaces in this line
	// <script>

	public Script(String scriptName) {
		readFile("/Scripts/" + scriptName + ".txt");
		this.name = this.script[0];
		this.script[1].replaceAll(" ", "");
		if (this.script[1].indexOf("repeat=") != -1 && (Integer.parseInt(this.script[1].substring(7)) > 0)) {
			// get int from string if it exists and save into max runs
			try {
				this.maxRuns = Integer.parseInt(this.script[1].substring(7));
			} catch (NumberFormatException e) {
				System.out.println("invalid repeat count in " + this.name);
			}
			doesRepeat = true;
		}
		if (this.script[1].indexOf("repeat=forever") != -1) {
			maxRuns = -1;
			doesRepeat = true;
		}
		if (doesRepeat) {
			currentLine = 2;
		}

	}

	public void reload() {
		// TODO load the same script back in and make updates to the code
		// TODO inventory needs to keep track of which scripts go where and it
		// needs to make sure that scripts can't be deleted / added outside of
		// the actual game. Scripts can only be "deleted" in the game menu or
		// in the editor
	}

	public void restart() {
		currentLine = 1;
		if (doesRepeat) {
			currentLine = 2;
		}
		runCount = 0;
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

		System.out.println(content); // for test purposes
	}

	/**
	 * Reads next line of script and returns it to be run
	 * 
	 * @return the next line of the script in String form to be run returns
	 *         empty string when script is over
	 */
	public String readNextLine() {
		String r = "";
		if (currentLine < script.length) {
			r = script[currentLine];
			currentLine++;
		}
		if (currentLine == script.length && (runCount < maxRuns || maxRuns == -1) && doesRepeat) {
			currentLine = 2;
			runCount++;
		}

		return r;
	}

}

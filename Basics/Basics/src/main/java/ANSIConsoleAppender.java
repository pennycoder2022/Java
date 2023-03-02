

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;

public class ANSIConsoleAppender extends ConsoleAppender {
	private static final int 	NORMAL = 				0;
	private static final int 	BRIGHT = 				1;
	
	private static final int 	FOREGROUND_RED = 		31;
	private static final int 	FOREGROUND_GREEN = 		32;
	private static final int 	FOREGROUND_YELLOW = 	33;
	private static final int 	FOREGROUND_BLUE = 		34;
	private static final int 	FOREGROUND_MAGENTA = 	35;
	private static final int 	FOREGROUND_CYAN = 		36;
	private static final int 	FOREGROUND_WHITE = 		37;

	private static final String PREFIX =		 		"\u001B[";
	private static final String SUFFIX =		 		"m";
	private static final String END_COLOUR =		 	PREFIX + 0 + SUFFIX;
	
	private static final String	FATAL_COLOUR =			PREFIX + FOREGROUND_RED +	SUFFIX;
	private static final String	ERROR_COLOUR =			PREFIX + FOREGROUND_RED + 	SUFFIX;
	private static final String	WARN_COLOUR =			PREFIX + FOREGROUND_YELLOW +SUFFIX;
	private static final String	INFO_COLOUR =			PREFIX + FOREGROUND_GREEN + SUFFIX;
	private static final String	DEBUG_COLOUR =			PREFIX + FOREGROUND_CYAN + 	SUFFIX;
	private static final String	TRACE_COLOUR =			PREFIX + FOREGROUND_WHITE + SUFFIX;
	
	protected void subAppend(LoggingEvent event) {
		this.qw.write(getColour(event.getLevel()));
		super.subAppend(event);
		this.qw.write(END_COLOUR);
		if(this.immediateFlush) this.qw.flush();
	}
	
	private String getColour(org.apache.log4j.Level level) {
		switch(level.toInt()) {
			case 	Priority.FATAL_INT: return FATAL_COLOUR;
			case 	Priority.ERROR_INT: return ERROR_COLOUR;
			case 	Priority.WARN_INT: 	return WARN_COLOUR;
			case 	Priority.INFO_INT: 	return INFO_COLOUR;
			case 	Priority.DEBUG_INT: return DEBUG_COLOUR;
			default:					return TRACE_COLOUR;
		}
	}
}
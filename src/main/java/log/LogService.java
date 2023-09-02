package log;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogService {
    public void createInfoLevel(boolean isActive, String text){
        if(isActive)
            log.info(text);
    }
}

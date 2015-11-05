package documentify.ext;

import java.util.Locale;
import net.sourceforge.stripes.format.Formatter;
import documentify.model.Request;

/**
 *
 * @author Russ
 */
public class RequestTypeFormatter implements Formatter<Request>{

    @Override
    public void setFormatType(String string) {
    }

    @Override
    public void setFormatPattern(String string) {
    }

    @Override
    public void setLocale(Locale locale) {
    }

    @Override
    public void init() {
    }

    @Override
    public String format(Request request) {
        return String.valueOf(request.getId());
    }
}

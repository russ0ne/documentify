package documentify.ext;

import java.util.Collection;
import java.util.Locale;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.TypeConverter;
import net.sourceforge.stripes.validation.ValidationError;
import documentify.dao.RequestDao;
import documentify.dao.impl.stripersist.RequestDaoImpl;
import documentify.model.Request;

/**
 *
 * @author Russ
 */
public class RequestTypeConverter implements TypeConverter<Request> {

    private final RequestDao requestDao = new RequestDaoImpl();

    @Override
    public void setLocale(Locale locale) {
    }

    @Override
    public Request convert(String string, Class<? extends Request> type, Collection<ValidationError> errors) {
        Request request = null;

        try {
            int id = Integer.valueOf(string);
            request = requestDao.read(id);
        }
        catch (NumberFormatException e) {
            errors.add(new SimpleError("The number {1} is not a valid Request ID", string));
        }

        return request;
    }

}

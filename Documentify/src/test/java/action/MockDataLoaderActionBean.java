/***
 * Excerpted from "Stripes: and Java Web Development is Fun Again",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/fdstr for more book information.
***/
package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import documentify.action.BaseActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import stripesbook.model.Contact;
import stripesbook.model.Folder;
import stripesbook.model.Gender;
import stripesbook.model.Message;
import stripesbook.model.PhoneNumber;
import stripesbook.model.User;

/** This Action Bean is only to load mock data into the database. */
public class MockDataLoaderActionBean extends BaseActionBean {
    @DefaultHandler
    public Resolution loadMockUser() throws Exception {
        if (userDao.findByUsername("freddy") == null) {
            User user = new User();

            user.setFirstName("Frederic");
            user.setLastName("Daoud");
            user.setUsername("freddy");
            user.setPassword("nadia");
            userDao.save(user);

            for (String folderName : Folder.DEFAULT_FOLDER_NAMES) {
                folderDao.save(new Folder(folderName, user));
            }
            userDao.commit();
            getContext().getMessages().add(getLocalizableMessage("mockUserLoaded"));
        }
        else {
            getContext().getMessages().add(getLocalizableMessage("mockUserAlreadyLoaded"));
        }
        return new RedirectResolution(LoginActionBean.class);
    }
    public Resolution loadMockMessages() throws Exception {
        Folder folder = getContext().getCurrentFolder();
        if (folder.getMessages().isEmpty()) {
            for (String string : RAW_INBOX) {
                messageDao.addMessageToFolder(createMessageFromString(string), folder);
            }
            messageDao.commit();
        }
        return new RedirectResolution(MessageListActionBean.class);
    }
    public Resolution loadMockContacts() throws Exception {
        User user = getUser();
        if (user.getContacts().isEmpty()) {
            for (String string : CONTACT_RAW_DATA) {
                Contact contact = createContactFromString(string);
                contact.setUser(user);
                contactDao.save(contact);
            }
            contactDao.commit();
        }
        return new RedirectResolution(ContactListActionBean.class);
    }
    private Message createMessageFromString(String string) throws Exception {
        String[] fields = string.split(",");

        Message message = new Message();

        message.setFrom(fields[FROM]);
        message.setTo(fields[TO]);
        message.setSubject(fields[SUBJECT]);
        message.setText(TEXT);
        message.setDate(mDateFormat.parse(fields[DATE]));

        return message;
    }
    private Contact createContactFromString(String string) throws Exception {
        String[] fields = string.split(",");

        Contact contact = new Contact();

        contact.setFirstName(fields[FIRST_NAME]);
        contact.setLastName(fields[LAST_NAME]);
        contact.setEmail(fields[EMAIL]);
        contact.setPhoneNumber(getPhoneNumber(fields[PHONE_NUMBER]));
        contact.setGender(Gender.valueOf(fields[GENDER]));
        contact.setBirthDate(cDateFormat.parse(fields[BIRTH_DATE]));

        return contact;
    }
    private PhoneNumber getPhoneNumber(String string) {
        return new PhoneNumber(
            string.substring(0, 3),
            string.substring(4, 7),
            string.substring(8)
        );
    }
    private static final DateFormat cDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final DateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private static final int FIRST_NAME   =  0;
    private static final int LAST_NAME    =  1;
    private static final int EMAIL        =  2;
    private static final int PHONE_NUMBER =  3;
    private static final int BIRTH_DATE   =  4;
    private static final int GENDER       =  5;

    private static final int FROM    =  0;
    private static final int TO      =  1;
    private static final int SUBJECT =  2;
    private static final int DATE    =  3;

    private static final String[] CONTACT_RAW_DATA = {
        "Sophie,Hunter,sh@stripesbook.org,555-555-8440,1981-08-08,Female",
        "Daniel,Greene,dg@stripesbook.org,555-555-7763,1986-06-03,Male",
        "Jen,Ballou,jb@stripesbook.org,555-555-6495,1982-08-30,Female",
        "Sammy,Blair,sb@stripesbook.org,555-555-9592,1981-06-02,Male",
        "Betty,Stocker,bs@stripesbook.org,555-555-8316,1987-05-22,Female",
        "Lou,Thompson,lt@stripesbook.org,555-555-2765,1980-08-29,Male",
        "Lexi,Hawk,lh@stripesbook.org,555-555-7211,1982-05-01,Female",
        "George,Wells,gw@stripesbook.org,555-555-7689,1987-05-15,Male",
        "Donna,McCallum,dm@stripesbook.org,555-555-3432,1979-12-28,Female",
        "Jason,Wilson,jw@stripesbook.org,555-555-4032,1978-04-03,Male",
    };
    private static final String[] RAW_INBOX = {
        "Daniel Greene,freddy@stripesbook.org,Congratulations!,2008-04-23 19:55",
        "Habibi,habibti@stripesbook.org,I love you Habibti,2008-04-19 14:42",
        "Sammy Blair,freddy@stripesbook.org,Re: lunch,2008-04-18 20:42",
        "Accounts-dept,freddy@stripesbook.org,Important info,2008-04-17 04:49",
        "George Wells,freddy@stripesbook.org,Need help with a web site I'm trying to set up..,2008-04-16 19:00",
        "Jen Ballou,freddy@stripesbook.org,last month's results,2008-04-15 18:09",
        "autocalendar,lunch-group,lunch,2008-04-13 16:34",
        "Lou Thompson,freddy@stripesbook.org,Es-tu disponible demain?,2008-04-11 22:44",
        "Jason Wilson,freddy@stripesbook.org,Tennis,2008-04-11 22:42",
        "automailer,hockeypool-list,Go Habs Go!,2008-04-02 23:52",
        "Lou Thompson,freddy@stripesbook.org,Re: just a quick question,2008-04-01 00:00",
        "Amazon.ca,freddy@stripesbook.org,Your order has shipped!,2008-03-28 17:57",
        "Sourceforge Administrator,freddy@stripesbook.org,Your password has been reset,2008-03-21 08:59",
        "autolist,freddy@stripesbook.org,Welcome to Stripes-developers,2008-03-15 14:11",
        "autolist,freddy@stripesbook.org,Welcome to Stripes-users,2008-03-02 06:11",
        "RQAP,freddy@stripesbook.org,Votre dossier est complet,2008-02-27 07:27",
        "OIQ,freddy@stripesbook.org,Bulletin aux membres,2008-02-16 02:55",
        "Jen Ballou,freddy@stripesbook.org,next month's results,2008-02-15 03:03",
        "JIRA,stripes-development@stripesframework.org,Resolved: STS-542,2008-02-14 12:08",
        "JIRA,stripes-development@stripesframework.org,Commented: STS-542,2008-02-02 09:04",
        "Jason Wilson,freddy@stripesbook.org,This is not spam,2008-02-02 09:02",
        "JIRA,stripes-development@stripesframework.org,Created: STS-542,2008-01-30 14:32",
        "Sophie Hunter,freddy@stripesbook.org,Problem solved,2008-01-29 12:28",
        "Daddy,coucou@stripesbook.org,I love you Peekaboo,2008-01-27 07:27",
        "Jason Wilson,freddy@stripesbook.org,Happy Birthday,2008-01-24 04:42",
    };
    private static final String TEXT =
          "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do "
        + "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad "
        + "minim veniam, quis nostrud exercitation ullamco laboris nisi ut "
        + "aliquip ex ea commodo consequat. Duis aute irure dolor in "
        + "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla "
        + "pariatur. Excepteur sint occaecat cupidatat non proident, sunt in "
        + "culpa qui officia deserunt mollit anim id est laborum.";
 }

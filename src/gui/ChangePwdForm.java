
package gui;

import com.codename1.components.FloatingHint;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import static gui.ActivateForm.emaill;
import services.ServiceUser;

/**
 * Account activation UI
 *
 * @author Shai Almog
 */
public class ChangePwdForm extends BaseForm {

    public ChangePwdForm(Resources res) {
        super(new BorderLayout());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("Container");
        getTitleArea().setUIID("Container");
        Form previous = Display.getInstance().getCurrent();
        tb.setBackCommand("", e -> previous.showBack());
        setUIID("Activate");
        
        add(BorderLayout.NORTH, 
                BoxLayout.encloseY(
                        new Label(res.getImage("smily.png"), "LogoLabel"),
                        new Label("Awsome Thanks!", "LogoLabel")
                )
        );
        
        TextField code = new TextField("", "Enter Password", 20, TextField.PASSWORD);
        TextField code1 = new TextField("", "Confirm Password", 20, TextField.PASSWORD);
        Button signUp = new Button("Change Password");
        Button resend = new Button("Resend");
        resend.setUIID("CenterLink");
        Label alreadHaveAnAccount = new Label("Already have an account?");
        Button signIn = new Button("Sign In");
        signIn.addActionListener(e -> new SignInForm(res).show());
        signIn.setUIID("CenterLink");
        
        Container content = BoxLayout.encloseY(
                new FloatingHint(code),
                createLineSeparator(),
                 new FloatingHint(code1),
                createLineSeparator(),
                signUp
        );
        content.setScrollableY(true);
        add(BorderLayout.SOUTH, content);
        signUp.requestFocus();
        resend.addActionListener(e ->  new ActivateForm(res).show());
        signUp.addActionListener(e -> {
            if(code.getText().equals(code1.getText())){
                 String mail = emaill;
             ServiceUser.getInstance().setPasswordByEmail(mail, code.getText().toString(), res);
            new NewsfeedForm(res).show();
            }else{
                Dialog.show("Erreur","Confirm Your Password","OK",null);
            }
           
        });
    }
    
}

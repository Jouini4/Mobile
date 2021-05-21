/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.sun.mail.smtp.SMTPTransport;
import gui.ActivateCodeForm;
import static gui.ActivateForm.emaill;
import gui.NewsfeedForm;
import gui.SessionManager;
import java.util.Date;
import utils.Statics;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author user
 */
public class ServiceUser {
    //singleton 
    public static ServiceUser instance = null ;
    
    public static boolean resultOk = true;
    String json;

    //initilisation connection request 
    private ConnectionRequest req;
    
    
    public static ServiceUser getInstance() {
        if(instance == null )
            instance = new ServiceUser();
        return instance ;
    }
    
    
    
    public ServiceUser() {
        req = new ConnectionRequest();
        
    }
    
    //Signup
    public void signup(TextField email,TextField password,TextField firstname,TextField lastname,TextField telephone,Picker date , Resources res ) {
    // String url = Statics.BASE_URL + "/user_signup?email=" + u.getEmail() + "&password=" + u.getPassword() + "&username=" + u.getUsername()+"&userphone="+u.getUserphone()+ "&useraddress="+u.getUseraddress()+"&usercin="+u.getUsercin();
        
         String datestring=(new SimpleDateFormat("yyyy-MM-dd")).format(date.getDate());
        String url = Statics.BASE_URL+"users/signup?email="+email.getText().toString()+"&password="+password.getText().toString()+"&firstname="+firstname.getText().toString()+
                "&lastname="+lastname.getText().toString()+"&telephone="+telephone.getText().toString()+"&datedenaissance="+datestring;
        
        req.setUrl(url);
       
        //Control saisi
        if(email.getText().equals("") || password.getText().equals("") || firstname.getText().equals("") || lastname.getText().equals("") || telephone.getText().equals("") || date.getValue().toString().equals("")) {
            
            Dialog.show("Erreur","Veuillez remplir les champs","OK",null);
            
        }
        
        //hethi wa9t tsir execution ta3 url 
        req.addResponseListener((e)-> {
         
            //njib data ly7atithom fi form 
            byte[]data = (byte[]) e.getMetaData();//lazm awl 7aja n7athrhom ke meta data ya3ni na5o id ta3 kol textField 
            String responseData = new String(data);//ba3dika na5o content 
            
            System.out.println("data ===>"+responseData);
        }
        );
        
        
        //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);
        
            
        
    }
    
    
//    //SignIn
    
    public void signin(TextField email,TextField password, Resources res ) {
        
        
        String url = Statics.BASE_URL+"users/signin?email="+email.getText().toString()+"&password="+password.getText().toString();
        req = new ConnectionRequest(url, false); //false ya3ni url mazlt matba3thtich lel server
        req.setUrl(url);
        
        req.addResponseListener((e) ->{
            
            JSONParser j = new JSONParser();
            
            String json = new String(req.getResponseData()) + "";
            
            
            try {
            
            if((json.equals("failed")) || (json.equals("passowrd not found"))) {
                Dialog.show("Echec d'authentification","Username ou mot de passe éronné","OK",null);
            }
            else {
                System.out.println("data =="+json);
                
                Map<String,Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
                
                //  Session 
               if(user.size() >0 ){
                   float id = Float.parseFloat(user.get("id").toString());
                SessionManager.setId((int)id);//jibt id ta3 user ly3ml login w sajltha fi session ta3i
               SessionManager.setEmail(user.get("email").toString());
                SessionManager.setPassowrd(user.get("password").toString());
                SessionManager.setFirstName(user.get("firstname").toString());
                SessionManager.setLastName(user.get("lastname").toString());
               // SessionManager.setDatenaissance(java.sql.Date.valueOf(user.get("datedenaissance").toString()));
                SessionManager.setTelephone(user.get("telephone").toString());
                float port = Float.parseFloat(user.get("wallet").toString());
                SessionManager.setportfeuille((int)port);
                float fidal = Float.parseFloat(user.get("fidality").toString());
                SessionManager.setfidality((int)fidal);
                 if(user.get("photo") != null)
                    SessionManager.setPhoto(user.get("photo").toString());
               }
              

                if(user.size() >0 ) // l9a user
                  new NewsfeedForm(res).show();//yemchi lel list reclamation
                   //new AjoutReclamationForm(rs).show();
                    
                    }
//            
            }catch(Exception ex) {
                ex.printStackTrace();
            }
            
            
            
        });
    
         //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
//
//  //heki 5dmtha taw nhabtha ala description
        public String userByEmail(String email, Resources rs, String cc) {
             String url = Statics.BASE_URL+"userbyemail?email="+email;
        req = new ConnectionRequest(url, false); //false ya3ni url mazlt matba3thtich lel server
        req.setUrl(url);
        
        req.addResponseListener((NetworkEvent e) ->{
            
            JSONParser j = new JSONParser();
            
             json = new String(req.getResponseData()) + "";
             if(json.equals("user not found")) {
                Dialog.show("Erreur","E_mail Not Found","OK",null);
            }
            else {
                  try {
                
            
          
                System.out.println("data =="+json);
                
                Map<String,Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
                
                if(user.size() >0 ) // l9a user
                  sendMail(emaill,cc,rs);
                  new ActivateCodeForm(rs).show();
            
            
            }catch(Exception ex) {
                ex.printStackTrace();
            }
            
            
            
             }
            
           
        });
    
         //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);
    return json;

        }
    public String setPasswordByEmail(String email,String passwordd, Resources rs ) {
        
        
        String url = Statics.BASE_URL+"getpassbyemail?email="+email+"&password="+passwordd;
        req = new ConnectionRequest(url, false); //false ya3ni url mazlt matba3thtich lel server
        req.setUrl(url);
        
        req.addResponseListener((e) ->{
            
            JSONParser j = new JSONParser();
            
             json = new String(req.getResponseData()) + "";
             if(json.equals("user not found")) {
                Dialog.show("Echec d'authentification","E_mail  éronné","OK",null);
            }
            else {
             }
            
            try {
                
            
          
                System.out.println("data =="+json);
                
                Map<String,Object> password = j.parseJSON(new CharArrayReader(json.toCharArray()));
                
                
            
            
            }catch(Exception ex) {
                ex.printStackTrace();
            }
            
            
            
        });
    
         //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);
    return json;
    }
    
     public void edit(TextField email,TextField password,TextField firstname,TextField lastname,TextField telephone,Picker date ,String photo, Resources res ) {
    // String url = Statics.BASE_URL + "/user_signup?email=" + u.getEmail() + "&password=" + u.getPassword() + "&username=" + u.getUsername()+"&userphone="+u.getUserphone()+ "&useraddress="+u.getUseraddress()+"&usercin="+u.getUsercin();
        String datestring=(new SimpleDateFormat("yyyy-MM-dd")).format(date.getDate());
        
        String url = Statics.BASE_URL+"users/editJSON/"+String.valueOf(SessionManager.getId())+"?email="+email.getText().toString()+"&password="+password.getText().toString()+"&firstname="+firstname.getText().toString()+
                "&lastname="+lastname.getText().toString()+"&tele="+telephone.getText().toString()+"&date="+datestring+"&photo="+photo;
        
        req.setUrl(url);
     }
     public void sendMail(String mail,String mp, Resources res) {
        try {
            
            Properties props = new Properties();
                props.put("mail.transport.protocol", "smtp"); //SMTP protocol
		props.put("mail.smtps.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtps.auth", "true"); //enable authentication
             
            Session session = Session.getInstance(props,null); // aleh 9rahach 5ater mazlna masabinach javax.mail .jar
            
            
            MimeMessage msg = new MimeMessage(session);
            
            msg.setFrom(new InternetAddress("faiz.daoud@esprit.tn"));
            msg.setRecipients(Message.RecipientType.TO, mail);
            msg.setSubject("SEIZE-IT : Confirmation du Client ");
            msg.setSentDate(new Date(System.currentTimeMillis()));
           String txt = "Bienvenue sur SEIZE-IT : Tapez ce Code : "+mp+" dans le champs requis et appuiez sur confirmer";
           
           
           msg.setText(txt);
           
          SMTPTransport  st = (SMTPTransport)session.getTransport("smtps") ;
            
          st.connect("smtp.gmail.com",465,"faiz.daoud@esprit.tn","192JMT0056");
           
          st.sendMessage(msg, msg.getAllRecipients());
            
          System.out.println("server response : "+st.getLastServerResponse());
          
        }catch(Exception e ) {
            e.printStackTrace();
        }
    }
}

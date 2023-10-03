//package dias.matheus.backendv1.blog.services;
//
//import org.springframework.stereotype.Service;
//
//
//
//@Service
//public class passwordEncoderService {
//
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    public PasswordEncoderService() {
//        this.passwordEncoder = new BCryptPasswordEncoder();
//    }
//
//    public String encodePassword(String rawPassword) {
//        return passwordEncoder.encode(rawPassword);
//    }
//
//    public boolean matches(String rawPassword, String encodedPassword) {
//        return passwordEncoder.matches(rawPassword, encodedPassword);
//    }
//
//}

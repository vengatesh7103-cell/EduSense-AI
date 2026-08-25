package Application;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@Service
public class AuthService {

	

	    private final UserRepository userRepository;
	    private final PasswordEncoder passwordEncoder;
	    private final AuthenticationManager authenticationManager;
	    private final JWTService jwtService;

	    public AuthService(UserRepository userRepository,
	                       PasswordEncoder passwordEncoder,
	                       AuthenticationManager authenticationManager,
	                       JWTService jwtService) {

	        this.userRepository = userRepository;
	        this.passwordEncoder = passwordEncoder;
	        this.authenticationManager = authenticationManager;
	        this.jwtService = jwtService;
	    }
	    
	    public String register(RegisterRequest request) {

	        if (userRepository.existsByEmail(request.getEmail())) {
	            throw new RuntimeException("Email already exists");
	        }

	        user newUser = new user();

	        newUser.setName(request.getName());
	        newUser.setEmail(request.getEmail());
	        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
	        newUser.setRole(request.getRole());

	        userRepository.save(newUser);

	        return "User Registered Successfully";
	    }
	    public AuthResponse login(LoginRequest request) {

	    	authenticationManager.authenticate(
	    	        new UsernamePasswordAuthenticationToken(
	    	                request.getEmail(),
	    	                request.getPassword())
	    	);

	        String token = jwtService.generateToken(request.getEmail());

	        return new AuthResponse(token, "Login Successful");
	    }
	    
	}


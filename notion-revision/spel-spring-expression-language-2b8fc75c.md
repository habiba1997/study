# SpEL Spring Expression Language

Source: https://app.notion.com/p/2b8fc75cbbd980a2b68bcf7eb8f2acdb?pvs=204

SpEL is a powerful expression language that supports querying and manipulating object graphs at runtime. It's used throughout Spring for dynamic value injection and evaluation.

### <b>Core Concepts</b>

SpEL provides:

- Dynamic property access and method invocation
- Conditional evaluation and operators
- Access to Spring beans and context
- Collection manipulation and projection

### <b>Where SpEL is Used in Spring</b>

### <b>1. @Value Annotation</b>

```java
@Component
public class MemberService {
    
    // Property injection
    @Value("${api.timeout:5000}")
    private int timeout;
    
    // System properties
    @Value("#{systemProperties['java.version']}")
    private String javaVersion;
    
    // Mathematical expressions
    @Value("#{${api.maxRetries} * 2}")
    private int doubleRetries;
    
    // Bean property access
    @Value("#{memberConfig.defaultRole}")
    private String defaultRole;
    
    // Method calls
    @Value("#{memberConfig.getRoleForLevel(2)}")
    private String level2Role;
    
    // Conditional
    @Value("#{${api.timeout} > 1000 ? 'slow' : 'fast'}")
    private String performanceMode;
}
```

### <b>2. @ConditionalOnExpression</b>

```java
@Configuration
@ConditionalOnExpression("${feature.oauth2.enabled:true} and '${spring.profiles.active}' == 'production'")
public class OAuth2Config {
    // Configuration only loaded if expression evaluates to true
}
```

### <b>3. Spring Security</b>

```java
@RestController
@RequestMapping("/api/members")
public class MemberController {
    
    @PreAuthorize("hasRole('ADMIN') and #userId == authentication.principal.id")
    @GetMapping("/{userId}")
    public Member getMember(@PathVariable Long userId) {
        return memberService.findById(userId);
    }
    
    @PostAuthorize("returnObject.universityId == principal.universityId")
    @GetMapping("/{memberId}/details")
    public MemberDetails getMemberDetails(@PathVariable Long memberId) {
        return memberService.getDetails(memberId);
    }
    
    @PreAuthorize("@securityService.hasAccessToUniversity(#universityId)")
    @PutMapping("/university/{universityId}")
    public void updateUniversityData(@PathVariable Long universityId) {
        // Custom security check via bean method
    }
}
```

### 4. Spring Data JPA Projections

```java
public interface UniversityProjection {
    String getName();
    String getState();
    
    // SpEL for computed properties
    @Value("#{target.name + ', ' + target.state}")
    String getFullLocation();
    
    @Value("#{target.departments.size()}")
    Integer getDepartmentCount();
    
    @Value("#{target.establishedYear < 1900 ? 'Historic' : 'Modern'}")
    String getEra();
    
    // Calling static methods
    @Value("#{T(java.time.LocalDate).now().getYear() - target.establishedYear}")
    Integer getAge();
}
```

<p />

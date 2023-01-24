package org.wyona.webapp.controllers.v1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;

import lombok.AllArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import org.wyona.webapp.controllers.v2.KatieConnectorController;
import org.wyona.webapp.models.katie.Answer;
import org.wyona.webapp.models.katie.Domain;
import org.wyona.webapp.models.katie.QnA;
import org.wyona.webapp.models.katie.Sentence;
import org.wyona.webapp.services.JwtService;

import javax.servlet.http.HttpServletRequest;
//import java.util.*;

/**
 * 'Katie Mockup Connector' Controller
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
//@AllArgsConstructor
public class KatieMockupConnectorController implements KatieConnectorController {

    @Value("${weaviate.host}")
    private String weaviateHost;

    @Value("${weaviate.protocol}")
    private String weaviateProtocol;

    @Value("${weaviate.basic.auth.username}")
    private String basicAuthUsername;

    @Value("${weaviate.basic.auth.password}")
    private String basicAuthPassword;

    @Autowired
    JwtService jwtService;

    private static final String CLAZZ_QUESTION = "Question";
    private static final String FIELD_QUESTION = "question";
    private static final String CLAZZ_ANSWER = "Answer";
    private static final String FIELD_ANSWER = "answer";
    private static final String CLAZZ_TENANT = "Tenant";
    private static final String FIELD_TENANT = "tenant";

    /**
     * @see org.wyona.webapp.controllers.v2.KatieConnectorController#createTenant(Domain, HttpServletRequest)
     */
    @PostMapping("/tenant")
    @ApiOperation(value = "Create tenant")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Bearer JWT",
                    required = false, dataType = "string", paramType = "header") })
    public ResponseEntity<String> createTenant(@RequestBody Domain domain, HttpServletRequest request) {
        if (!isAuthorized(request)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        log.info("TODO: Create tenant associated with Katie domain ID '" + domain.getId() + "' ...");
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    /**
     * @see org.wyona.webapp.controllers.v2.KatieConnectorController#deleteTenant(String, HttpServletRequest)
     */
    @DeleteMapping("/tenant/{domain-id}")
    @ApiOperation(value = "Delete tenant")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Bearer JWT",
                    required = false, dataType = "string", paramType = "header") })
    public ResponseEntity<?> deleteTenant(
            @ApiParam(name = "domain-id", value = "Katie domain ID", required = true)
            @PathVariable(name = "domain-id", required = true) String domainId,
            HttpServletRequest request
    ){
        if (!isAuthorized(request)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        log.info("TODO: Delete tenant associated with Katie domain ID '" + domainId + "' ...");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * @see org.wyona.webapp.controllers.v2.KatieConnectorController#train(QnA, String, HttpServletRequest)
     */
    @PostMapping("/qna/{domain-id}")
    @ApiOperation(value = "Add QnA")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Bearer JWT",
                    required = false, dataType = "string", paramType = "header") })
    public ResponseEntity<String> train(
            @RequestBody QnA qna,
            @ApiParam(name = "domain-id", value = "Katie domain ID", required = true)
            @PathVariable(name = "domain-id", required = true) String domainId,
            HttpServletRequest request
    ) {
        if (!isAuthorized(request)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        log.info("TODO: Train QnA ...");
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    /**
     * @see org.wyona.webapp.controllers.v2.KatieConnectorController#getAnswers(Sentence, String, HttpServletRequest)
     */
    @PostMapping("/ask/{domain-id}")
    @ApiOperation(value = "Ask question")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Bearer JWT",
                    required = false, dataType = "string", paramType = "header") })
    public ResponseEntity<Answer[]> getAnswers(
            @RequestBody Sentence question,
            @ApiParam(name = "domain-id", value = "Katie domain ID", required = true)
            @PathVariable(name = "domain-id", required = true) String domainId,
            HttpServletRequest request
    ) {
        if (!isAuthorized(request)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        log.info("TODO: Get answers to question '" + question.getText() + "' ...");
        Answer[] answers = new Answer[0];
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    /**
     * @see org.wyona.webapp.controllers.v2.KatieConnectorController#deleteQnA(String, String, HttpServletRequest)
     */
    @DeleteMapping("/qna/{domain-id}/{uuid}")
    @ApiOperation(value = "Delete QnA")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Bearer JWT",
                    required = false, dataType = "string", paramType = "header") })
    public ResponseEntity<?> deleteQnA(
            @ApiParam(name = "domain-id", value = "Katie domain ID", required = true)
            @PathVariable(name = "domain-id", required = true) String domainId,
            @ApiParam(name = "uuid", value = "UUID of QnA", required = true)
            @PathVariable(name = "uuid", required = true) String uuid,
            HttpServletRequest request
    ) {
        if (!isAuthorized(request)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        log.info("TODO: Delete QnA '" + uuid + "' ...");
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    /**
     * Check authorization of request
     * @return true when authorized and false otherwise
     */
    private boolean isAuthorized(HttpServletRequest request) {
        String jwtToken = getJWT(request);
        if (jwtToken == null) {
            return false;
        }
        log.info("Issuer: " + jwtService.getPayloadValue(jwtToken, "iss"));
        // TODO: Retrieve public key from https://ukatie.com/swagger-ui/#/authentication-controller/getJWTPublicKeyUsingGET
        if (jwtService.isJWTValid(jwtToken, null)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get JWT from Authorization request header
     */
    private String getJWT(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            if (authorizationHeader.indexOf("Bearer") >= 0) {
                return authorizationHeader.substring("Bearer".length()).trim();
            } else {
                log.warn("Authorization header does not contain prefix 'Bearer'.");
                return null;
            }
        } else {
            log.warn("No Authorization header.");
            return null;
        }
    }
}

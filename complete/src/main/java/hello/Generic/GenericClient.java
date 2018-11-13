package hello.Generic;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.net.URI;

public class GenericClient<V, T>  {
//    public ResponseEntity<T> execute(RequestDetails<V> requestDetails, Class<T> responseType, Object... uriVariables) {
//        System.out.println("I am in");
//        ResponseEntity<T> response;
//        try {
//            final String url = requestDetails.getUrl();
//            URI expandedUrl = restTemplate.getUriTemplateHandler().expand(url, uriVariables);
//            logger.debug("Request endpoint is ==> {}", expandedUrl.toURL());
//
//            HttpEntity<V> entity = new HttpEntity<V>(requestDetails.getPayload(), requestDetails.getHttpHeaders());
//
//
//            response = restTemplate.exchange(requestDetails.getUrl(), requestDetails.getHttpMethod(), entity, responseType, uriVariables);
//
//            if (response.getStatusCode().is2xxSuccessful()) {
//                ObjectMapper objectMapper = new ObjectMapper();
//                logger.debug("Response is ==> {}", objectMapper.writeValueAsString(response.getBody()));
//            }
//            return response;
//
//
//        } catch (HttpClientErrorException e) {
//            HttpStatus statusCode = e.getStatusCode();
//            String responseBody = e.getResponseBodyAsString();
//            if (statusCode.equals(HttpStatus.NOT_FOUND)) {
//                String notFound = String.format("Resources not found, status code is: %s, response body is %s", statusCode, responseBody);
//                logger.error(notFound);
//                throw new HttpNotFoundException(notFound);
//            } else if (statusCode.equals(HttpStatus.FORBIDDEN)) {
//                String forbidden = String.format("URI forbidden, status code is: %s, response body is %s", statusCode, responseBody);
//                logger.error(forbidden);
//                throw new ForbiddenException(forbidden);
//            } else if (statusCode.equals(HttpStatus.BAD_REQUEST)) {
//                String badRequest = String.format("URI bad request, status code is: %s, response body is %s", statusCode, responseBody);
//                logger.error(badRequest);
//                throw new HttpMessageNotReadableException(badRequest);
//            } else {
//                String clientError = String.format("Client error exception, status code is: %s, response body is %s", statusCode, responseBody);
//                logger.error(clientError);
//                throw new HttpClientErrorException(statusCode, clientError);
//            }
//        } catch (HttpServerErrorException serverErrorException) {
//            String httpServerError = String.format("Http Server Error %s : %s ", serverErrorException.getStatusCode(),
//                    serverErrorException.getResponseBodyAsString());
//            logger.error(httpServerError);
//            throw serverErrorException;
//        } catch (Exception e) {
//            logger.error("Exception while retrieving information {}", e.getMessage());
//            throw new RuntimeException(e);
//        }
//    }
}

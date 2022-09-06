package com.springbootandvueproject.demoproject.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.loader.custom.NonUniqueDiscoveredSqlAliasException;

/**
 * @author Zha_Aibek@mail.com
 */
@AllArgsConstructor
@NoArgsConstructor
public class InvalidCredentialsError extends Error {
   String msg;

}

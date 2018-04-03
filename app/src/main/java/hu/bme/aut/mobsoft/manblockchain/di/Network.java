package hu.bme.aut.mobsoft.manblockchain.di;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

@Qualifier
@Retention(RUNTIME) // not needed
public @interface Network {
}

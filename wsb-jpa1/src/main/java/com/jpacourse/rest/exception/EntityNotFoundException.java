<<<<<<< HEAD
package com.jpacourse.rest.exception;

public class EntityNotFoundException extends RuntimeException
{

    public EntityNotFoundException(Long id)
    {
        super("Could not find entity of id " + id);
    }
}
=======
package com.jpacourse.rest.exception;

public class EntityNotFoundException extends RuntimeException
{

    public EntityNotFoundException(Long id)
    {
        super("Could not find entity of id " + id);
    }
}
>>>>>>> 73c4b2f (Edit PatientController, PatientServiceImp, PatientService and application.properties)

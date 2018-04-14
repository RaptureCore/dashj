#include "NeoscryptWrapper.h"
#include "neoscrypt.h"
#include <stdint.h>



jbyteArray JNICALL Java_com_rapture_NeoscryptWrapper_neoscrypt(JNIEnv *env, jobject obj, jbyteArray inputArray, jbyteArray outputArray)
{
  //puts("Called New Neoscrypt function .....");
  jbyte *input = (*env)->GetByteArrayElements(env,inputArray,NULL);
  jbyte *output = (*env)->GetByteArrayElements(env,outputArray,NULL);
  jbyteArray hash = NULL;

  neoscrypt((const uint8_t*)input,(uint8_t*)output,0x0);
   hash = (*env)->NewByteArray(env,32);
  
    if (hash)
    	{
    		(*env)->SetByteArrayRegion(env,hash, 0, 32, output);
    	}
    	if (input) (*env)->ReleaseByteArrayElements(env,inputArray, input, 0);
      if (output) (*env)->ReleaseByteArrayElements(env, outputArray, output, 0);
  
        return hash;
}


/*
 Copyright 2017, Brett Wooldridge

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.zaxxer.sansorm.transaction;

public class TxThreadContext
{
   private static final ThreadLocal<TxThreadContext> threadContext = new ThreadLocal<TxThreadContext>() {
      @Override
      protected TxThreadContext initialValue()
      {
         return new TxThreadContext();
      }
   };

   private volatile TxTransaction transaction;

   static TxThreadContext getThreadContext()
   {
      return threadContext.get();
   }

   TxTransaction getTransaction()
   {
      return transaction;
   }

   void setTransaction(final TxTransaction transaction)
   {
      this.transaction = transaction;
   }

   void clearTransaction()
   {
      transaction = null;
   }
}

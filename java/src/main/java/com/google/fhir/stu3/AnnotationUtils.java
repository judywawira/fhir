//    Copyright 2018 Google Inc.
//
//    Licensed under the Apache License, Version 2.0 (the "License");
//    you may not use this file except in compliance with the License.
//    You may obtain a copy of the License at
//
//        https://www.apache.org/licenses/LICENSE-2.0
//
//    Unless required by applicable law or agreed to in writing, software
//    distributed under the License is distributed on an "AS IS" BASIS,
//    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//    See the License for the specific language governing permissions and
//    limitations under the License.package com.google.research.health.fhir.stu3;

package com.google.fhir.stu3;

import com.google.fhir.stu3.proto.Annotations;
import com.google.fhir.stu3.proto.Annotations.StructureDefinitionKindValue;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.MessageOrBuilder;

/** Helper methods for dealing with FHIR protocol buffer annotations. */
public final class AnnotationUtils {

  public static boolean isResource(Descriptor descriptor) {
    return descriptor.getOptions().hasExtension(Annotations.structureDefinitionKind)
        && descriptor.getOptions().getExtension(Annotations.structureDefinitionKind)
            == StructureDefinitionKindValue.KIND_RESOURCE;
  }

  public static boolean isResource(MessageOrBuilder message) {
    return isResource(message.getDescriptorForType());
  }

  public static boolean isPrimitiveType(Descriptor descriptor) {
    return descriptor.getOptions().hasExtension(Annotations.structureDefinitionKind)
        && descriptor.getOptions().getExtension(Annotations.structureDefinitionKind)
            == StructureDefinitionKindValue.KIND_PRIMITIVE_TYPE;
  }

  public static boolean isPrimitiveType(MessageOrBuilder message) {
    return isPrimitiveType(message.getDescriptorForType());
  }

  public static boolean isReference(Descriptor descriptor) {
    return descriptor.getOptions().getExtensionCount(Annotations.fhirReferenceType) > 0;
  }

  public static boolean isReference(MessageOrBuilder message) {
    return isReference(message.getDescriptorForType());
  }
}

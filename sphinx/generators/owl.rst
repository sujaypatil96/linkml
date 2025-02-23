Owl
======

Overview
--------

Web Ontology Language
`OWL <https://www.w3.org/TR/2012/REC-owl2-overview-20121211/>`__ is
modeling language used to author ontologies.

OWL is used for building *ontologies*, whereas LinkML is a *schema*
language. Nevertheless, it can be useful to render Schemas as OWL (and
in fact many semantic web schemas such as PROV have an OWL or RDFS
rendering)


.. seealso:: The `linkml-owl <https://github.com/linkml/linkml-owl>`_
             maps between LinkML *data* and OWL
             
.. note:: The OWL is rendered as RDF/turte. We recommend the suffix
          ``.owl.ttl`` to distinguish from the direct RDF mapping
             
.. warning:: Currently imports are included in the rendered OWL, this
             means if you import linkml/types these will also be
             rendered, which can be confusing

Mapping
^^^^^^^

* Each LinkML class maps to an OWL class
* Each LinkML slot maps to an OWL property

    - if the range of the slot is class, then an ObjectProperty is used
    - otherwise DataProperty is used

* OWL *restrictions* are used for cardinality and range constraints

    - ``only`` (universal restrictions) is used for ranges
    - If a slot is not `multivalued` then a ``max 1`` cardinality
      restrictions are used
    - required non-multivalued slots have an ``exactly 1`` cardinality restriction
    - required multivalued slots have a ``min 1`` cardinality
      restriction
    - it should be understood that OWL follows the Open World
      Assumption, thus OWL reasoners enforce a weaker model
  
* Each LinkML element is rendered as an instance of the relevant metamodel class      

    - This means *punning* is used
    - In future this behavior may be configurable
      
Docs
----

Command Line
^^^^^^^^^^^^

.. currentmodule:: linkml.generators.owlgen

.. click:: linkml.generators.owlgen:cli
    :prog: gen-owl
    :nested: short

Code
^^^^

                   
.. autoclass:: OwlGenerator
    :members: serialize
